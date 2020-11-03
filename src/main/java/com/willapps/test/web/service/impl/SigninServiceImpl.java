package com.willapps.test.web.service.impl;

import com.willapps.test.vo.ResultEnm;
import com.willapps.test.web.service.SigninService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SigninServiceImpl implements SigninService {

    //缓存手机号码
    private static Map<String,String> phoneMap = new HashMap<>();

    private static final int CHINA_PHONE_LENGTH = 13;

    @Override
    public ResultEnm signIn(String phoneNumber) {
        if(!isMobile(phoneNumber)){
            try {
                String realNum = getRealNum(phoneNumber);
                if(realNum.length()!=CHINA_PHONE_LENGTH){
                    return ResultEnm.NOT_CHINA_NUMBER;
                }
            }catch (Throwable e){
            }
            return ResultEnm.BAD_NUMBER;
        }
        String realNum = getRealNum(phoneNumber);
        if(phoneMap.containsValue(realNum)){
            return ResultEnm.NUMBER_REPEAT;
        }
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        phoneMap.put(id,realNum);
        return ResultEnm.SUCCESS;
    }

    /**
     * 获得真实手机号
     * @param phoneNumber
     * @return
     */
    public static String getRealNum(String phoneNumber){
        return phoneNumber.replaceAll(" ","");
    }

    /**
     * 手机号验证
     * @param  str
     * @return 验证通过则返回true
     */
    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{1}?[ ][0-9]{4}?[ ][0-9]{4}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }
}
