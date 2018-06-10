package com.example.jpaTest.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@RequestMapping(value="/find/{name}")
	public User getUserByName(@PathVariable("name") String name) {
		return userService.getUserByName(name);
	}
	
	@GetMapping(value="/user")
	public ArrayList<User> getAll() {
		return userService.findAll();
	}
	
	@GetMapping(value="/user/{id}")
	public User getById(@PathVariable("id") Integer id) {
		return userService.findById(id);
	}
	
	@PostMapping(value="/user")
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
	
	@PutMapping(value="/user/{id}")
	public User updateUser(@PathVariable("id") Integer id,
							@RequestParam("userName") String userName,
							@RequestParam("email") String email) {
		User user = userService.findOne(id);		
		user.setUserName(userName);
		user.setEmail(email);
		return userService.save(user);
	}
	
	@DeleteMapping(value="/user/{id}")
	public void deleteUser(@PathVariable("id") Integer id){
		userService.delete(id);
	}

}
