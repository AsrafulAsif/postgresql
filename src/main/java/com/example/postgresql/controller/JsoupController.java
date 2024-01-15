package com.example.postgresql.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jsoup")
public class JsoupController {

    @Value("${secret.param}")
    private String baseUrl;

    @GetMapping()
    public String getData(){
        return baseUrl;
    }

}
