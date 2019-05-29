package com.mengxuegu.controller;/*
 *
 *  @Author:shipeixin
 *  @Date:2019/5/29 21:09
 *
 */


import com.mengxuegu.dao.UserRepository;
import com.mengxuegu.entity.User;
import com.mengxuegu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.get();
        return user;
    }


    @GetMapping("/addUser")
    public User addUser(User user){
        User saveUser = userRepository.save(user);
        return saveUser;
    }


    @GetMapping("addManyUser")
    public User addManyUser(User user){
        userService.addUser(user);
        return user;
    }


}
