package com.mengxuegu.controller;/*
 *
 *  @Author:shipeixin
 *  @Date:2019/5/30 17:10
 *
 */


import com.mengxuegu.entities.User;
import com.mengxuegu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userService.getUserById(id);
        return user;
    }


    @GetMapping("/updateUser")
    public User updateUser(User user){
        userService.updateUser(user);
        return user;
    }




    @GetMapping("/deleteUser/{id}")
    public Integer deleteUser(@PathVariable("id") Integer id){
         userService.deleteUserById(id);
        return id;
    }

}
