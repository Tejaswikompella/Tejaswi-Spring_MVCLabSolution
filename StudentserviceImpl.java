 package com.greatlearning.StudentRecord.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.greatlearning.StudentRecord.entity.Student;


@Repository
public class StudentserviceImpl implements StudentService {

	private SessionFactory sessionfactory;
	private Session session;
	
	
	public StudentserviceImpl(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
		try
		{
			session=this.sessionfactory.getCurrentSession();
		}catch(HibernateException e)
		{
			session=this.sessionfactory.openSession();
		}
	}
	
	@Transactional
	public List<Student> findAll()
	{
		List<Student> studentList=session.createQuery("from Student").list();
		return studentList;
	}
	
	@Transactional
	public Student findById(Integer id)
	{
		Student student=session.get(Student.class,id);
		return student;
	}
	
	@Transactional
	public void save(Student student)
	{
		Transaction tr =session.beginTransaction();
		session.saveOrUpdate(student);
		tr.commit();
	}
	
	@Transactional
	public void delete(Student s)
	{
		Transaction tr =session.beginTransaction();
		session.delete(s);
		tr.commit();
	}
}
