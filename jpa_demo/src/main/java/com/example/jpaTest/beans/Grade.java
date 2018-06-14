package com.example.jpaTest.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Grade {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String gradeId;
	
	private String gradeName;
	
	@Transient //该注解使字段不与数据库进行关联
	private String test;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", gradeId=" + gradeId + ", gradeName=" + gradeName + "]";
	}
	

}