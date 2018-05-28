package com.example.webTest.common;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	
	@Bean
	public RemoteIpFilter remoteIpFilter() {
		return new RemoteIpFilter();
	}
	
	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new MyFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("MyFilter");
		registration.setOrder(Integer.MAX_VALUE);
		return registration;
	}
	
	@Bean
	public FilterRegistrationBean filterRegisterBean() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new MyFilter1());
		registration.addUrlPatterns("/boot");
		registration.addInitParameter("name", "value");
		registration.setName("MyFilter1");
		registration.setOrder(Integer.MAX_VALUE-1);
		return registration;
	}
	

}
