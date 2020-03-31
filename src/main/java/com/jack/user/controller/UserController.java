package com.jack.user.controller;

import com.jack.utils.MD5Utils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author LYY
 * @Date 2019/8/13
        */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/get/user")
    @ResponseBody
    public Object getUser(){
        System.out.println("UserController.getUser");
        String password = "lyy123";
        Map<String,String> map = new HashMap<>();
        map.put("username","lyy");
        map.put("password", MD5Utils.getMD5(password));
        return map;
    }

    @PostMapping("/print/date")
    @ResponseBody
    public Object printDate(@RequestParam("date")@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")Date date){
        System.out.println(date);
        return null;
    }



    @PostMapping("/print/array")
    @ResponseBody
    public Object array(List<String> ids){
        System.out.println(ids);
        return null;
    }
}
