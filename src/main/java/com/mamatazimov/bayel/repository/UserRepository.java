package com.mamatazimov.bayel.repository;

import com.mamatazimov.bayel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getUserById(Long id);
}
