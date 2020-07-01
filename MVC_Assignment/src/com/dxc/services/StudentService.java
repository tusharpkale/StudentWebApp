package com.dxc.services;

import java.util.List;

import com.dxc.dao.StudentDao;
import com.dxc.pojos.Student;

public class StudentService 
{
	StudentDao dao=new StudentDao();
			
	public void addStudent(Student s)
	{
		dao.addStudent(s);
	}
	
	public List<Student> getAllStudents()
	{
		return dao.getAllStudents();
	}
	
	public boolean findStudent(int rollno)
	{
		return dao.findStudent(rollno);
	}
	public void updateStudent(Student s)
	{
		dao.updateStudent(s);
	}
	public boolean removeStudent(int rollno)
	{
		return dao.removeStudent(rollno);
	}


}
