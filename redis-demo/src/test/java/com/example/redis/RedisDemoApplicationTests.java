package com.example.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.redis.model.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	

	@Test
	public void set() {
		Person person = new Person("小明", "20");
		redisTemplate.opsForValue().set("001", person.toString());
		Object object = redisTemplate.opsForValue().get("001");
		System.out.println(object.toString());
	}
	


}
