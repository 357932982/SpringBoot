package com.example.service_ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service_ribbon.service.HelloService;

@RestController
public class HelloController {
	
	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value="/hi")
	public String hello(@RequestParam("name") String name) {
		return helloService.hiService(name);
	}

}
