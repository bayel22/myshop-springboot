package com.bayel22.repository;

import com.bayel22.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class UserRepository {
    private List<User> users = new ArrayList<User>(Arrays.asList(
            new User(1L, "hi1", "h2", "@gmail", "123"),
            new User(2L, "hi2", "h2", "@gmail", "1234")
    ));

    public User getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
