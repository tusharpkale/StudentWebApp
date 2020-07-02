package com.dxc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pojos.Student;

public class StudentDao {
	
	private static Connection conn;
	
	//Change in file dao
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded...");
			
		 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tushar?autoReconnect=true&useSSL=false", "root", "password");
			System.out.println("connected to database....");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void addStudent(Student s){
		try {
			PreparedStatement pstmt=conn.prepareStatement("insert into student values(?,?,?)");
			pstmt.setInt(1, s.getRollno());
			pstmt.setString(2, s.getName());
			pstmt.setDouble(3, s.getPercentage());
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> getAllStudents() {
		List<Student> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from student");
			while(rs.next())
			{
				list.add(new Student(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean findStudent(int rollno)
	{
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from student");
			while(rs.next())
			{
				if(rollno==rs.getInt(1))
				{
					return true;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public void updateStudent(Student s){
		try {
			PreparedStatement pstmt=conn.prepareStatement("update student set name=?, percentage=? where rollno=?");
			pstmt.setString(1, s.getName());
			pstmt.setDouble(2, s.getPercentage());
			pstmt.setInt(3, s.getRollno());
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean removeStudent(int rollno)
	{
		boolean status=false;
		try {
			PreparedStatement pstmt=conn.prepareStatement("delete from student where rollno=?");
			pstmt.setInt(1, rollno);
			status=pstmt.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return !status;
	}
	
}
