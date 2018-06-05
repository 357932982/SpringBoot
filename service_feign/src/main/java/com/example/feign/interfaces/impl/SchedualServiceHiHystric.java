package com.example.feign.interfaces.impl;

import org.springframework.stereotype.Component;

import com.example.feign.interfaces.SchedualServiceHi;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{

	@Override
	public String sayHiFromClientOne(String name) {
		// TODO Auto-generated method stub
		return "sorry: " + name;
	}

}
