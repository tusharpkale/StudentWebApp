package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;

import com.dxc.pojos.Student;

public class StudentDao {
	
	private List<Student> list=new ArrayList<>();
	
	public void addStudent(Student s){
		
		list.add(s);
	}
	
	public List<Student> getAllStudents()
	{
		return list;
	}
}
