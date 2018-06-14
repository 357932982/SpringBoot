package com.example.mybatis.mapper;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.mybatis.entity.Student;

public interface StudentMapper {

	@Select("select * from Student")
	@Results({
		@Result(property = "id", column = "id"),
		@Result(property = "name", column = "name"),
		@Result(property = "age", column = "age"),
		@Result(property = "email", column = "email"),
		@Result(property = "grade", column = "grade"),
	})
	List<Student> findAll();
	
	@Select("select name from Student")
	List<String> findName();
	
	@Select("select * from student where id = #{id}")
	Student fingById(Integer id);
	
	@Insert("insert into student (name, age, email, grade) values (#{name}, #{age}, #{email}, #{grade})")
	void insert(Student student);
	
	@Update("update student set name=#{name}, age=#{age} where id=#{id}")
	void update(Student student);
	
	@Delete("delete from student where id = #{id}")
	void delete(Integer id);
	
	
	@Select("select s.name, s.age, s.email, g.gradeName from student s, grade g where s.grade=g.gradeId and s.grade=#{grade}")
	List<Map<String, Object>> findStudentAndGrade(String grade);
}
