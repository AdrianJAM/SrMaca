package com.srmaca.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/api/hola")
    public String holamundo(){
        return  "Hola Mundo";
    }
}