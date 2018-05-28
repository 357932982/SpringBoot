package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @SpringBootApplication: 是@Configuration、@EnableAutoConfiguration、@ComponentScan的简化形式
 * 1.@Configuration：用来配置和初始化类（由Spring IOC）完成。
 * 2.@EnableAutoConfiguration：自动配置Spring APP的上下文，通常放在root包下，从而保证所有的子包、类都能被扫描到。
 * 3.@ComponentScan：用来自动扫描指定包下的全部标有@Component注解及其子
 *   注解(@Service、@Repository、@Controller)的类，并注册成bean.
 * @author yms
 *
 */
@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
}
