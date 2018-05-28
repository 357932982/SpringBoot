package com.example.jpaTest.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpaTest.beans.User;
import com.example.jpaTest.service.UserService;

import antlr.collections.List;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getUserByName")
	public User getUserByName(String name) {
		return userService.getUserByName(name);
	}
	
	@GetMapping(value="/all")
	public ArrayList<User> getAll() {
		return userService.findAll();
	}
	
	@PostMapping(value="/insert", produces = "text/plain;charset=UTF-8")
	public User insert(HttpServletRequest request) {
		User user = new User();
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String email = request.getParameter("email");
		user.setUserName(userName);
		user.setPassWord(passWord);
		user.setEmail(email);
		return userService.save(user);
	}
}
