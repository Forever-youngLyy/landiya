package com.jack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication/*(exclude = DataSourceAutoConfiguration.class)*/
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Class<SpringBootApplication> aClass = SpringBootApplication.class;
    }

}
