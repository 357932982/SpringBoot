package com.example.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.feign.interfaces.SchedualServiceHi;


@RestController
public class FeignController {

	@Autowired
	SchedualServiceHi schedualServiceHi;
	
	@RequestMapping(value="/hi")
	public String sayHi(@RequestParam("name") String name) {
		return schedualServiceHi.sayHiFromClientOne(name);
		
	}
}
