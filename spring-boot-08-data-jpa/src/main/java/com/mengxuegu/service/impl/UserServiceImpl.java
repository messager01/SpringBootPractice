package com.mengxuegu.service.impl;/*
 *
 *  @Author:shipeixin
 *  @Date:2019/5/29 21:22
 *
 */

import com.mengxuegu.dao.UserRepository;
import com.mengxuegu.entity.User;
import com.mengxuegu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED)   // 当前方法开启事务管理
    @Override
    public Boolean addUser(User user) {
        userRepository.save(new User("1","1"));
        userRepository.save(new User("2","2"));
        userRepository.save(new User("3","3"));
        userRepository.save(new User("4","4"));
        userRepository.save(new User("5","5"));
        userRepository.save(new User("6","6"));
        //  模拟错误
        int i = 1 / 0;
        userRepository.save(user);

        return null;
    }
}
