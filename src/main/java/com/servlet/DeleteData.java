package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entitys.StudentData;
import com.Helper.FactoryProvider;


public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteData() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try {
		int studentId = Integer.parseInt(request.getParameter("st_id").trim());
		Session s = FactoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		 StudentData sd=(StudentData)s.get(StudentData.class,studentId);
		s.delete(sd);
		tx.commit();
		s.close();
		response.sendRedirect("index.jsp");
	} catch (Exception e) {
		// TODO: handle exception
	}
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
