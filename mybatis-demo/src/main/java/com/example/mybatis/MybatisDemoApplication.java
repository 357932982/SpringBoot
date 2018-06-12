package com.example.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatis.mapper") //用来扫描mapper， 也可采用在每个mapper类上加@Mapper注解
public class MybatisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisDemoApplication.class, args);
	}
}
