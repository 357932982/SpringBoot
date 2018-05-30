package com.example.service_ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplatel;
	
	public String hiService(String name) {
		return restTemplatel.getForObject("http://SERVICE-HI?name="+name, String.class);
	}
	
}
