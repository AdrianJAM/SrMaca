package com.srmaca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class HelloController {
    public String hello(){
        return "Hello World";
    }
}
