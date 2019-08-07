package com.petro.apiary.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String sayHello() {
        String datatime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd - MMMM - yyyy -- HH:mm:ss"));
        return "Rest Service is now available     " +
                "IT`S WORKING. Now is : ___ " +
                datatime;
    }
}
