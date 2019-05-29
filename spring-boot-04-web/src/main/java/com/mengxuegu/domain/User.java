package com.mengxuegu.domain;


import lombok.Data;

@Data
public class User {
    private String userName;

    private Integer gender;


    public User(String userName, Integer gender) {
        this.userName = userName;
        this.gender = gender;
    }
}
