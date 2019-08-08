package com.petro.apiary.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest/test")
public class ApiRestTestController {

    public ApiRestTestController() {
    }

    @GetMapping("admin")
    public String testApiAdmin(){
        return "Hello Admin";
    }

    @GetMapping("director")
    public String testApiDirector(){
        return "Hello Director";
    }

    @GetMapping("worker")
    public String testApiUser(){
        return "Hello Worker";
    }
}
