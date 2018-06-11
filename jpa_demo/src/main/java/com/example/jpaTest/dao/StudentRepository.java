package com.example.jpaTest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaTest.beans.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
}
