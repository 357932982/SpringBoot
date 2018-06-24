package com.example.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.thymeleaf.model.Person;

@Controller
public class TestController {

    @RequestMapping(value = "/index")
    public String index(Model model) {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("小明", "18"));
        people.add(new Person("阿花", "8"));
        people.add(new Person("如花", "12"));
        people.add(new Person("卡卡", "10"));
        model.addAttribute("people", people);
        model.addAttribute("title", "测试Thymeleaf");
        return "index";
    }

    @RequestMapping(value = "/main")
    public String main(Model model) {
        return "main";
    }

}
