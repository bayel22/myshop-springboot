package com.bayel22.service;

import com.bayel22.entity.User;
import com.bayel22.repository.impl.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }

}
