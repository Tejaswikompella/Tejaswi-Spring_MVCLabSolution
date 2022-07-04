package com.greatlearning.StudentRecord.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.StudentRecord.entity.Student;
import com.greatlearning.StudentRecord.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService ss;
	
	@RequestMapping("/list")
	public String findAll(Model model)
	{
		List<Student> studentList=ss.findAll();
		model.addAttribute("studentList", studentList);
		return "Students";
	}
	
	@RequestMapping("/save")
	public String save(@RequestParam("id") Integer id,@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("country") String country)
	{
		Student s=null;
		if(id!=-1)
		{
			s=ss.findById(id);
			s.setFirstName(firstName);
			s.setLastName(lastName);
			s.setCountry(country);
		}	
		else
			s=new Student(firstName,lastName,country);
		
		ss.save(s);
		return "redirect:list";
	}
	
	@RequestMapping("/addStudent")
	public String addStudent(@RequestParam("id") Integer id,Model model)
	{
		if(id!=-1)
		{
			Student s=ss.findById(id);
			model.addAttribute("student", s);
		}
		else
		{
			Student s=new Student();
			s.setId(-1);
			model.addAttribute("student", s);
		}
		return "StudentForm";
	}
	
	@RequestMapping("/deleteStudent")
	public String delete(@RequestParam("id") Integer id)
	{
		Student s=null;
		if(id!=-1)
		{
			s=ss.findById(id);
			ss.delete(s);
		}
		return "redirect:list";
	}
	
}
