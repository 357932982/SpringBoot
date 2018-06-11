package com.example.jpaTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpaTest.beans.Student;
import com.example.jpaTest.beans.User;
import com.example.jpaTest.dao.StudentRepository;
import com.example.jpaTest.dao.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaDemoApplicationTests {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void contextLoads() {
		User user = userRepository.findByUserNameOrAge("静静", 10);
		System.out.println(user);
	}
	
	@Test
	public void testStudent() {
		Student student = new Student();
		student = studentRepository.getOne(1);
		System.out.println(student);
	}

}
