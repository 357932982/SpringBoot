package com.example.configClient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${profile}")
    private String name;

    @RequestMapping(value = "/hi")
    public String hi() {
        return this.name;
    }
}
