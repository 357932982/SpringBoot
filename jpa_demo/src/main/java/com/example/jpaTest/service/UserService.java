package com.example.jpaTest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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

}
