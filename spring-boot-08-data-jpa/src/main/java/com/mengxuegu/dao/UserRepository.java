package com.mengxuegu.dao;

import com.mengxuegu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/*
*
*     自定义接口继承JpaRepository    就会有crud操作   且分页排序等功能
*
* */



//  指定的泛型<操作的实体类，主键的额数据类型>
public interface UserRepository extends JpaRepository<User,Integer> {
}
