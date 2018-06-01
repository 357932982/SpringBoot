package com.example.feign.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="service-hi")
public interface SchedualServiceHi {

	@RequestMapping(value="/hi")
	public String sayHiFromClientOne(@RequestParam("name") String name);
}
