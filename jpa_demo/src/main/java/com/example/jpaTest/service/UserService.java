package com.example.jpaTest.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.jpaTest.beans.User;
import com.example.jpaTest.dao.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUserByName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public ArrayList<User> findAll() {
		return (ArrayList<User>) userRepository.findAll();
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User findById(Integer id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User findOne(Integer id) {
		User user = new User();
		user.setId(id);
		Example<User> userExample = Example.of(user);
		return userRepository.findOne(userExample).orElse(user);
	}
	
	public String delete(Integer id) {
		userRepository.deleteById(id);
		return "OK";
	}

}
