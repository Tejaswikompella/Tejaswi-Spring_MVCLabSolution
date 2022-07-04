package com.greatlearning.StudentRecord.service;

import java.util.List;

import com.greatlearning.StudentRecord.entity.Student;

public interface StudentService {

	public List<Student> findAll();

	public void save(Student s);
	
	public Student findById(Integer id);

	public void delete(Student s);
}
