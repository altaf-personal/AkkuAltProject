package com.mersi.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.Statement;

//Create another class called Employee and have attributes like name, id, and other details. 

/**
 * This class fetch and save employee.
 * @author Shan
 *
 */
public class EmployeeDao {
	
	/**
	 * 
	 */
	Connection con;
	
	//Cons doc required
	public EmployeeDao() {
		//Remove the below auto generated comments.
		// TODO Auto-generated method stub

		try{
		//We need to add this to someother place or in a separate class. A new database connection is not required to done every time, DB connection creations are costly and affect performance.
			//we should load it once in a application and use it ever. Will discuss on this
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shan","root","java");

		}
		catch(Exception e){
			System.out.println("Cannot connect to Database Shan "+e);
		}
	}
	
	/**
	 * Save the employee data
	 * @param id
	 * @param name
	 * @param des
	 * @param sal
	 */
	public void saveEmployee(int id, String name, String des, int sal){ 
		try{

				String insertQuery = "insert into employeeInfo values(?,?,?,?,?)";			
				PreparedStatement ps = con.prepareStatement(insertQuery);
				float bon = (sal*10)/100;
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, des);
				ps.setInt(4, sal);
				ps.setFloat(5, bon);
				ps.executeUpdate();
				System.out.println("Data Successfully updated");
		}	
		catch(Exception e){
			System.out.println("Cannot connect to Database Shan "+e);
			
		}

	}
	
	/**
	 * Show employee data for given Employee ID
	 * @param id
	 */
	public void showEmployee(int id){
		
		try{
			Statement stmt = con.createStatement();
			String query = "Select empId, empName, empDesignation, empSalary, empBonus from employeeInfo where empId="+id;
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Employee ID\tEmployee Name\tDesignation\tSalary\tBonus");
			while(rs.next()){
				
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getInt(4)+"\t"+rs.getInt(5));
			}
			
		}catch(Exception e){
			System.out.println("Cannot connect to Database"+e);
			}
	}
	
	/**
	 * Show all Employee data
	 */
	public void showAllEmployees(){
		
		try{
			Statement stmt = con.createStatement();
			String query = "Select * from employeeInfo";
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("Employee ID\tEmployee Name\tDesignation\tSalary\tBonus");
			while(rs.next()){
				
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getInt(4)+"\t"+rs.getInt(5));
			}
			
		}catch(Exception e){
			System.out.println("Cannot connect to Database"+e);
		}
	}

}
