package com.mengxuegu.entity;


/*
*
*   JPA 采用的是ORM(对象关系映射)
* */

import lombok.Data;

import javax.persistence.*;

@Data
@Entity     //  说明它是和数据库表映射的类
@Table(name = "tbl_user")    //指定对应映射的表明  如果不写  则默认表明是类名
public class User {

    @Id  // 指定为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // 自增长
    private Integer id;

    @Column(name = "user_name")    //  与数据库表对应的字段   省略不写  默认字段名就是属性名
    private String username;

    @Column(name = "password")
    private String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public User() {
    }
}
