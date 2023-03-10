package com.training.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.training.springmvc.model.User;
@Repository
public class HomeDaoImpl implements HomeDao{
	@Override
	public List<User> getUsers() {
		List<User> userList = new ArrayList<>();
		 Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 
	        //Scanner sc = new Scanner(System.in);
	        String url = "jdbc:mysql://localhost:3306/demo_1";
	        String user = "root";
	        String pass = "india@123";
	        con = DriverManager.getConnection(url,user,pass);
	        
	        if(con!=null) {
	        	System.out.println("success");
	        }
	        else {
	        	System.out.println("Not connected");
	        }
	        
	        
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from JDBC_1");
	        while(rs.next()) {
	          	userList.add(new User(rs.getString(1), rs.getString(2)));
	        	
	        }
	       
		 }  
	        catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return userList;
	}

}
