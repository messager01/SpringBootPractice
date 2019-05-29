package com.mengxuegu.controller;


import com.mengxuegu.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller

public class HelloController {

    @RequestMapping("/success")
    @ResponseBody
    public String hello(){
        return "hello world";
    }


    @RequestMapping("/execute")
    public String success(Model model){
        model.addAttribute("name","梦学谷");
        // 在classpath:/templates下寻找success.html
        return "success";
    }

    @RequestMapping("/study")
    public String study(Model model, HttpServletRequest request){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("A",1));
        users.add(new User("B",2));
        users.add(new User("C",2));
        users.add(new User("D",1));
        model.addAttribute("userList",users);
        model.addAttribute("sex",1);
        model.addAttribute("man","2");


        model.addAttribute("desc","welcome to <h1>NYC</h1>");

        //  将user绑定到session中
        request.getSession().setAttribute("user",new User("小刘",2));

        return "study";
    }
}
