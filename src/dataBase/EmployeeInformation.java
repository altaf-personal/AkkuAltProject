package dataBase;
//Package wrong  as previous class
//Documentation missing as pre

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.Statement;

//Class documentation missing as previous class.
//Name the class as 'EmployeeDao' or EmployeeRepository (Dao means Data Access Object - which is a known standard to fetch, save, update database ), that is enough
//Create another class called Employee and have attributes like name, id, and other details. 
public class EmployeeInformation {
	
	//Doc required
	Connection con;
	
	//Cons doc required
	public EmployeeInformation() {
		//Remove the below auto generated comments.
		// TODO Auto-generated method stub
		try{
		//Intentation required means a tab.
		//We need to add this to someother place or in a separate class. A new database connection is not required to done every time, DB connection creations are costly and affect performance.
			//we should load it once in a application and use it ever. Will discuss on this
			//CAn you explain me in  atext pad what this class.forName does.
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shan","root","java");
		}
		catch(Exception e){
			System.out.println("Cannot connect to Database Shan "+e);
		}
	}
	
	//Method doc required// Change  method declaration as save(Employee )
	public void newEmpData(int id, String name, String des, int sal){ 
		try{
			
			//Rname table in db as emloyee
			String insertQuery = "insert into employeeInfo values(?,?,?,?,?)";			
			PreparedStatement ps = con.prepareStatement(insertQuery);
			//Set these attribute in the new Employee class.
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
	
	//Method do required
	//Change fetch(int - Why you used int here? anser me.
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
	
	//Method do required. change to fetchAll.
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
