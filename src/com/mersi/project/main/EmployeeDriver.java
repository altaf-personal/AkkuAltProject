package com.mersi.project.main;


import java.io.DataInputStream;
import com.mersi.project.dao.*;
import java.io.IOException;
import java.util.Scanner;

//NOTE: I have rewritten the class as EmployeeDriver in referenceclass package, please look.
/**
 * User Interface
 * @author Shan
 *
 */
public class EmployeeDriver {

	public static void main(String[] args) throws IOException {
		

		String userConfirmationInput;
		do{
			//Should not use sysouts, for now it is ok. Future we will write a logging framework
			System.out.println("Select your option:\n1:Add new employee Detail\n2:Search an employee data\n3:View whole employee Details");
			Scanner scannerInput = new Scanner(System.in);
			DataInputStream streamInput = new DataInputStream(System.in);
			int userInput = scannerInput.nextInt();
			switch(userInput){
				case 1:
					System.out.println("Enter Employee ID");
					int id = scannerInput.nextInt();
					System.out.println("Enter Employee Name");
					String name = streamInput.readLine();
					System.out.println("Enter Employee Designation");
					String des = streamInput.readLine();
					System.out.println("Enter Employee Salary");
					int sal = scannerInput.nextInt();
					EmployeeDao eInfo = new EmployeeDao();
					eInfo.saveEmployee(id, name, des, sal);
					break;
				case 2:
					EmployeeDao eData = new EmployeeDao();
					System.out.println("Enter Employee ID");
					int id1 = scannerInput.nextInt();
					eData.showEmployee(id1);
					break;
				case 3:
					EmployeeDao eAllData = new EmployeeDao();
					eAllData.showAllEmployees();
					break;
				default:
					System.out.println("WrongSelection either type y/n");
		}
			System.out.println("\nDo you want to continue y/n");
			userConfirmationInput= scannerInput.next();
			scannerInput.close();
		}while(userConfirmationInput.equals("y"));
		System.out.println("Thanks for using");
	}

}
