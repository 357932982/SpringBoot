package com.example.mybatis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.mybatis.entity.Student;
import com.example.mybatis.mapper.StudentMapper;


@RestController
public class StudentController {

	@Autowired
	private StudentMapper studentMapper;
	
	@RequestMapping(value="/name")
	public List<String> name(){
		return studentMapper.findName();
	}
	
	@GetMapping(value="/student")
	public List<Student> find() {
		return studentMapper.findAll();
	}
	
	@GetMapping(value="/student/{id}")
	public Student findOne(@PathVariable("id") Integer id) {
		return studentMapper.fingById(id);
	}
	
	@PostMapping(value="/student")
	public String insert(@RequestParam("name") String name,
						 @RequestParam("age") Integer age,
						 @RequestParam("email") String email,
						 @RequestParam("grade") String grade) {
		Student student = new Student(name, age, email, grade);
		studentMapper.insert(student);
		return "ok!";
	}
	
	@PutMapping(value="/student/{id}")
	public String update(@PathVariable("id") Integer id,
						 @RequestParam("name") String name,
						 @RequestParam("age") Integer age) {
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setAge(age);
		studentMapper.update(student);
		return "ok!";
	}
	
	@DeleteMapping(value="/student/{id}")
	public String delete(@PathVariable("id") Integer id) {
		studentMapper.delete(id);
		return "OK!";
	}
	
	@RequestMapping(value="/find/{grade}")
	public String findStudentAndGrade(@PathVariable("grade") String grade) {
		List<Map<String, Object>> list = studentMapper.findStudentAndGrade(grade);
		JSONArray array = new JSONArray();
		for (Map<String, Object> map : list) {
			System.out.println(map);
			JSONObject json = new JSONObject(map);
			System.out.println(json);
			array.add(json);
		}
		return array.toJSONString();
	}
	
}
