package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entitys.StudentData;
import com.Helper.FactoryProvider;

public class EditData extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public EditData() {
        super();

    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			int st_id = Integer.parseInt(request.getParameter("st_id").trim());
			String name = request.getParameter("name");
			 String age = request.getParameter("age");
			 String location = request.getParameter("location");

			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			 StudentData sd=(StudentData)s.get(StudentData.class,st_id);

			 sd.setAge(name);
			 sd.setAge(age);
			 sd.setLocation(location);
			 sd.setAddedDate(new Date());
			 tx.commit();
			 s.close();
			 response.sendRedirect("index.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
