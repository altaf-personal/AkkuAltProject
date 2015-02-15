package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.Statement;

public class EmployeeInformation {
	Connection con;
	public EmployeeInformation() {
		// TODO Auto-generated method stub
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shan","root","java");
		}
		catch(Exception e){
			System.out.println("Cannot connect to Database Shan "+e);
		}
	}
	
	public void newEmpData(int id, String name, String des, int sal){ 
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
	
	public void seeEmpData(int id){
		
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
	
	public void seeAllEmpData(){
		
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
