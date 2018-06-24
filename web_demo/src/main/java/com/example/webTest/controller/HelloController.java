package com.example.webTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;


@RestController
public class HelloController {

    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Value("${name}")
    private String myName;
    @Value("${value}")
    private String value;
    @Value("${title}")
    private String title;
    @Value("${age}")
    private int age;

    @RequestMapping(value = "/hi")
    public String hi() {
        logger.info("hi");
        logger.info("---------");
        logger.error("error");
        ;
        return "hi";
    }

    @RequestMapping(value = "/boot")
    public String boot() {
        return "你好，小明";
    }

    @RequestMapping(value = "info")
    public JSONObject getValues() {
        JSONObject json = new JSONObject();
        json.put("name", myName);
        json.put("value", value);
        json.put("title", title);
        json.put("age", age);
        System.out.println(age);
        return json;
    }

}
