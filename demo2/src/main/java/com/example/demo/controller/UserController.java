package com.example.demo.controller;

import com.example.demo.poio.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("users")
@RestController
public class UserController {
    @RequestMapping("add1")
    public String add1(String username,String password){
        System.out.println("username="+username);
        System.out.println("password="+password);
        return "success";
    }
    @RequestMapping("add2")
    public String add2(User user){
        System.out.println("user="+user);
        return "success";
    }
//    restful风格
    @RequestMapping("add3/{username}/{password}")
    public String add3(@PathVariable String username, @PathVariable String password){
        System.out.println("username="+username);
        System.out.println("password="+password);
        return "success";
    }
    @RequestMapping("add4")
    public String add4(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println("username="+username);
        System.out.println("password="+password);
        return "success";
    }
    @RequestMapping("add5")
    public User add5(@RequestBody User user){
        System.out.println(user);
        return user;
    }
}
