package com.bayel22.service;

import com.bayel22.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        try(context) {
            UserService userService = context.getBean(UserService.class);
            System.out.println(userService.getUserById(1L));
        }
    }
}
