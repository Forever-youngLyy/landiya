package com.jack.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/time")
public class TimeController {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
    @RequestMapping("get/time")
    public Object getTime(){
        return LocalDateTime.now().format(dtf);
    }
}
