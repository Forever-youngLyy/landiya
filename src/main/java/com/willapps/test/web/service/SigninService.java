package com.willapps.test.web.service;

import com.willapps.test.vo.ResultEnm;

public interface SigninService {

    /**
     * 注册手机号
     * @param phoneNumber
     * @return
     */
    ResultEnm signIn(String phoneNumber);
}
