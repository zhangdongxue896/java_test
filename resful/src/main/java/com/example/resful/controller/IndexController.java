package com.example.resful.controller;
//import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Index")
public class IndexController {

    @GetMapping("/RESTful")
    public String getRESTful(){
        return "点击了Get";
    }

    @DeleteMapping("/RESTful")
    public String deleteRESTful(){
        return "点击了delete";
    }
    @PutMapping("/RESTful")
    public String putRESTful(){
        return "点击了put";
    }
    @PostMapping("/RESTful")
    public String postRESTful(){
        return "点击了post";
    }
}


