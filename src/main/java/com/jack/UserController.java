package com.jack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LYY
 * @Date 2019/8/13
 */
@Controller
public class UserController {
    @RequestMapping
    @ResponseBody
    public Object getUser(){
        System.out.println("UserController.getUser");
        Map<String,String> map = new HashMap<>();
        map.put("username","lyy");
        map.put("password","lyy123");
        return map;
    }
}
