package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AnimalCRUD {
	public static boolean SaveAnimal(String name,int legs,int life) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_001?user=root&password=Keshav");
			PreparedStatement ps=con.prepareStatement("INSERT INTO animal VALUES(?,?,?)");
			ps.setString(1,name);
			ps.setInt(2,legs);
			ps.setInt(3,life);
			ps.execute();
			con.close();
			return true;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static ResultSet getAnimal() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_001","root","Keshav");
			Statement st=con.createStatement();
			String sql="SELECT * FROM animal";
			return st.executeQuery(sql);
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
