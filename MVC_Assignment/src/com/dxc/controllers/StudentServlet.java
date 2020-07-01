package com.dxc.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.pojos.Student;
import com.dxc.services.StudentService;


@WebServlet("/stud")
public class StudentServlet extends HttpServlet {
	
	StudentService service=new StudentService();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String message;
		String action="";
		String temp=request.getParameter("btn");
		if(temp!=null)
			action=request.getParameter("btn");
		HttpSession session=request.getSession();
		if(action.equals("add_student"))
		{
			int rollno=Integer.parseInt(request.getParameter("rollno"));
			String name=request.getParameter("name");
			double percentage=Double.parseDouble(request.getParameter("percentage"));
			
			Student s1=new Student(rollno, name, percentage);
			service.addStudent(s1);
			message="Student added successfully!";
			session.setAttribute("message", message);
			response.sendRedirect("view.jsp");
		}
		else
		{
			List<Student> list=service.getAllStudents();
			session.setAttribute("list", list);
			response.sendRedirect("showStudents.jsp");
			
		}
		
	}


}
