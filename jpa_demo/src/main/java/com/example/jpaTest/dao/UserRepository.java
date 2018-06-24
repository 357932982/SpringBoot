package com.example.jpaTest.dao;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaTest.beans.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

    Optional<User> findById(Integer id);

    //自定义简单查询
    User findByUserNameOrAge(String userName, Integer age);

}
