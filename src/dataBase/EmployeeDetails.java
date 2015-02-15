package dataBase;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeDetails {

	@SuppressWarnings({ "resource", "deprecation" })
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String d;
		do{
		System.out.println("Select your option:\n1:Add new employee Detail\n2:Search an employee data\n3:View whole employee Details");
		Scanner in = new Scanner(System.in);
		DataInputStream ins = new DataInputStream(System.in);
		int userInput = in.nextInt();
		switch(userInput){
		case 1:
			System.out.println("Enter Employee ID");
			int id = in.nextInt();
			System.out.println("Enter Employee Name");
			String name = ins.readLine();
			System.out.println("Enter Employee Designation");
			String des = ins.readLine();
			System.out.println("Enter Employee Salary");
			int sal = in.nextInt();
			EmployeeInformation eInfo = new EmployeeInformation();
			eInfo.newEmpData(id, name, des, sal);
			break;
		case 2:
			EmployeeInformation eData = new EmployeeInformation();
			System.out.println("Enter Employee ID");
			int id1 = in.nextInt();
			eData.seeEmpData(id1);
			break;
		case 3:
			EmployeeInformation eAllData = new EmployeeInformation();
			eAllData.seeAllEmpData();
			break;
		default:
			System.out.println("WrongSelection either type y/n");
		}
		System.out.println("\nDo you want to continue y/n");
		in = new Scanner(System.in);
		d= in.next();
		}while(d.equals("y"));
		System.out.println("Thanks for using");
	}

}
