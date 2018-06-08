package com.example.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //用来刷新请求
public class RabbitMQController {
	
	@Value("${profile}")
	private String name;
	
	@RequestMapping(value="/hi")
	public String hi() {
		return this.name;
	}

}
