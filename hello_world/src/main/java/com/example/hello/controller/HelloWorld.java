package com.example.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController:相当于@ResponseBody+@Controller。代表这个class所有的方法都是返回值或者对象到本页面
 * @author yms
 *
 */
@RestController
public class HelloWorld {

	@RequestMapping(value="/hello")
	public String say() {
		return "Hello World";
	}
}
