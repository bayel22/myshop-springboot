package com.bayel22.service;

import java.util.List;
import java.util.Optional;

import com.bayel22.entity.User;
import com.bayel22.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(
        readOnly = true
)
public class UserService {
    private final UserRepository repo;

    public Optional<User> findById(Long id) {
        return this.repo.findById(id);
    }

    public List<User> findAll() {
        List<User> all = this.repo.findAll();
        return all;
    }

    @Transactional
    public User save(User user) {
        this.repo.save(user);
        return user;
    }

    @Transactional
    public void delete(User user) {
        this.repo.delete(user);
    }

    @Transactional
    public void deleteById(Long id) {
        this.repo.deleteById(id);
    }


    public UserService(UserRepository repo) {
        this.repo = repo;
    }
}