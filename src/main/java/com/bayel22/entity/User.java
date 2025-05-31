package com.bayel22.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private Long id;

    private String firstName;
    private String lastName;

    private String email;
    private String password;
}
