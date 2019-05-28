package com.mengxuegu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InitController {
    @RequestMapping("/info")
    @ResponseBody
    public String init(){
        return "hello init";
    }
}
