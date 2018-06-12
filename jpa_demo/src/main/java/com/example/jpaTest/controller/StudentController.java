package com.example.jpaTest.controller;

import java.util.ArrayList;

import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl11;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpaTest.beans.Student;
import com.example.jpaTest.dao.StudentRepository;


@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(value="/student/{id}")
	public String student(@PathVariable("id") Integer id) {
		return studentRepository.getOne(id).toString();
	}
	
	@RequestMapping(value="/test")
	public ArrayList<Student> test() {
//		return studentRepository.findByNameOrAge("小明1", 12);
//		return studentRepository.findByNameOrAgeOrGrade("小明0", 45, "2");
//		return studentRepository.findByAgeLessThan(18);
//		return studentRepository.findByGradeEquals("3");
//		return studentRepository.findByGradeIsAndAgeLessThan("1", 12);
//		return studentRepository.findByGradeIsOrAgeLessThan("3", 12);
//		return studentRepository.findFirstByOrderByAgeDesc();
//		return studentRepository.findTopByOrderByAgeDesc();
		Sort sort = new Sort(Direction.ASC, "id");
		return studentRepository.findFirst10ByGrade("1", sort);

	}
	
	@RequestMapping(value="/modify")
	public void test1() {
		studentRepository.modifyById("静静", 18, 1);
	}
	
	@RequestMapping(value="/page/{page}/{size}")
	public Page<Student> page(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		//分页查询
		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(page, size, sort);
		
		return studentRepository.findAll(pageable);
	}
}
