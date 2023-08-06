package com.org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.AnimalCRUD;
@WebServlet("/display")

public class Displayanimal extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResultSet rs=AnimalCRUD.getAnimal();
		PrintWriter pw=resp.getWriter();
		try {
			pw.write("<html><body><table border=2px>");
			pw.write("<tr><th>name</th><th>legs</th><th>life</th></tr>");
			while(rs.next())
			{
				pw.write("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getInt(2)+"</td><td>"+rs.getInt(3)+"</td></tr>");
			}
			pw.write("</table></body></html>");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}