package com.bayel22.service;


import com.bayel22.config.AppConfig;
import com.bayel22.entity.User;
import com.bayel22.repository.UserRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        try(context) {
            UserRepository bean = context.getBean(UserRepository.class);
            List<User> userById = bean.getUserById(1L);
            System.out.println(userById);
        }
    }
}
