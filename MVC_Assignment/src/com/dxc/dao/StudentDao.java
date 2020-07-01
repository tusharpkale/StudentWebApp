package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;

import com.dxc.pojos.Student;

public class StudentDao {
	
	private List<Student> list=new ArrayList<>();
	
	public void addStudent(Student s){
		list.add(s);
	}
	
	public List<Student> getAllStudents() {
		return list;
	}
	
	public boolean findStudent(int rollno)
	{
		for(Student s:list)
		{
			if(s.getRollno()==rollno)
			{
				return true;
			}
		}
		return false;
	}
	
	public void updateStudent(Student s){
		int index=0;
		for(Student st:list)
		{
			if(st.getRollno()==s.getRollno())
			{
				break;
			}
			index++;
		}
		list.set(index, s);
	}
	
	public boolean removeStudent(int rollno)
	{
		int index=0;
		int flag=0;
		for(Student st:list)
		{
			if(st.getRollno()==rollno)
			{
				flag=1;
				break;
			}
			index++;
		}
		if(flag==0)
			return false;
		
		list.remove(index);
		return true;
	}
}
