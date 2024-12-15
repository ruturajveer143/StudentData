package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entitys.StudentData;
import com.Helper.FactoryProvider;


public class SaveStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public SaveStudentServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

		String name = request.getParameter("studentName");
		String age = request.getParameter("studentAge");
		String location = request.getParameter("studentLocation");




		StudentData sd = new StudentData(name,age,location,new Date());

//			System.out.println(sd.getId()+" "+sd.getName());

	Session s =	FactoryProvider.getFactory().openSession();
	Transaction tx =s.beginTransaction();
	s.save(sd);
	tx.commit();
	s.close();

	response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
