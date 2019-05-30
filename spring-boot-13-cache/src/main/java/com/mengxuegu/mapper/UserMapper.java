package com.mengxuegu.mapper;/*
 *
 *  @Author:shipeixin
 *  @Date:2019/5/30 16:58
 *
 */

import com.mengxuegu.entities.User;

public interface UserMapper {

    User getUserById(Integer id);

    Integer updateUser(User user );

    Integer addUser(User user);

    Integer deleteUserById(Integer id);
}
