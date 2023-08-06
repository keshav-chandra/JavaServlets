package com.org.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.AnimalCRUD;
@WebServlet("/ani")
public class GetAnimal extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		//System.out.println(name);
		int legs=Integer.parseInt(req.getParameter("legs"));
		int life=Integer.parseInt(req.getParameter("life"));
		PrintWriter pw=resp.getWriter();
		boolean res=AnimalCRUD.SaveAnimal(name, legs, life);
		//System.out.println(res);
		if(res) {
			pw.write("<h1>Animal data inserted sucessfully</h1>");
		}else {
			pw.write("<h1>Something went wrong!!!</h1>");
		}
		
	}
	
}

	


