package com.bayel22.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private Long id;

    private String firstName;
    private String lastName;

    private String email;
    private String password;
}
