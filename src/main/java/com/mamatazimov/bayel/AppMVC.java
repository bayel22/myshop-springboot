package com.mamatazimov.bayel;

import com.mamatazimov.bayel.entity.User;
import com.mamatazimov.bayel.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppMVC {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppMVC.class, args);
        UserService bean = context.getBean(UserService.class);
        User userNotFound = bean.findById(1L).orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println(userNotFound);
    }
}