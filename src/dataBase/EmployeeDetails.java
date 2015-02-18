package dataBase;
//Package name is wrong, this should be in src.mersi.project.driver package or something meaningful.


import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

//NOTE: I have rewritten the class as EmployeeDriver in referenceclass package, please look.

//Althaf review comments - Start
//Class document missing, need to write what this class doing. Look at java string class.
public class EmployeeDetails {

	//Althaf review comments - Start
	//Should not always suppress warnings. You should look in to the below warnings.
	//1. The first warning could be a possible memory leak in future
	//2. Deprecated method(ex - ins.readLine(), the method name which shown as striked through) should not be used.
	//Althaf review comments - End
	//@SuppressWarnings({ "resource", "deprecation" })
	public static void main(String[] args) throws IOException {
		//Althaf review comments - Start
		//Alway remove the below comment 'TODO Auto -generated...'
		//Althaf review comments - End
		// TODO Auto-generated method stub
		
		//Althaf review comments - Start
		//Naming convention wrong here, should nt be d - a meaning ful name should be given.
		String d;
		//Althaf review comments - End
		do{
			//Althaf review comments - Start
			// A tab required for a block of code to easy understanding of code.
			//Should not use sysouts, for now it is ok. Future we will write a logging framework
		System.out.println("Select your option:\n1:Add new employee Detail\n2:Search an employee data\n3:View whole employee Details");
		
		//Althaf review comments - End
		//Althaf review comments - Start
		//Naming convention wrong - Can be inputScanner or something meaning ful.
		Scanner in = new Scanner(System.in);
		//Althaf review comments - Start
		//Althaf review comments - Start
		//Meaning ful name required instead of ins
		DataInputStream ins = new DataInputStream(System.in);
		//Althaf review comments - End
		int userInput = in.nextInt();
		switch(userInput){
		//Althaf review comments - Start
		// A tab required for a block of code to easy understanding of code.
		//End
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
		//Althaf review comments - Start
		// A tab required for a block of code till below while.
		}while(d.equals("y"));
		System.out.println("Thanks for using");
	}

}
