package com.example.jpaTest.dao;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.jpaTest.beans.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	ArrayList<Student> findByNameOrAge(String name, Integer age);
	
	ArrayList<Student> findByNameOrAgeOrGrade(String name, Integer age, String grade);
	
	ArrayList<Student> findByAgeLessThan(Integer age);
	
	ArrayList<Student> findByGradeEquals(String grade);
	
	ArrayList<Student> findByGradeIsAndAgeLessThan(String grade, Integer age);
	
	ArrayList<Student> findByGradeIsOrAgeLessThan(String grade, Integer age);
	
	//限制查询
	Student findFirstByOrderByAgeDesc();
	//限制查询
	Student findTopByOrderByAgeDesc();
	//限制查询
	ArrayList<Student> findFirst10ByGrade(String grade, Sort sort);
	ArrayList<Student> findFirst10ByGrade(String grade, Pageable pageable);
	
	Page<Student> queryFirst10ByGrade(String grade, Pageable pageable);
	
	//自定义SQL查询
	//@Transactional // 添加事物支持，用于提交事务，若没有带上这句，会报事务异常提示。
	//	也可用来进行事物的设置，为了保证事物的完整性，该注解尽量添加在service层。
	@Modifying //涉及到删除和修改需要这个注解
	@Query("update Student set name = ?1, age = ?2 where id = ?3")// 注意Student需要与实体类中的类名一直！！！！！
	int modifyById(String name, Integer age, Integer id);
	
	//多表查询
	@Query("select s.name, s.age, s.email, s.grade, g.gradeName from Student s, Grade g where s.grade = g.gradeId")
	Object[][] findStudentsAndGradeName();

}
