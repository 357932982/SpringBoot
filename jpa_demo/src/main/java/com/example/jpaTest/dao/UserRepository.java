package com.example.jpaTest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaTest.beans.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String userName);

}
