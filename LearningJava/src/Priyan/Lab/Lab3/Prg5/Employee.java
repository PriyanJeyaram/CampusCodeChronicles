package Priyan.Lab.Lab3.Prg5;
import java.util.Scanner;
public class Employee {
	String empName, empAddress;
	char empGender;
	int empAge;
	Scanner t = new Scanner(System.in);
	Employee() {
		System.out.println("...Common Data Entry...");
		System.out.print("Enter Employee Name: ");
		empName = t.next();
		System.out.print("Enter Employee Address: ");
		empAddress = t.next();
	    System.out.print("Enter Employee Gender: ");
		empGender = t.next().charAt(0);
		System.out.print("Enter Employee Age: ");
		empAge = t.nextInt();
	}
	public void displayEmpDetails() {
		System.out.println("...Displaying Employee Details...");
		System.out.println("Employee Name: " + empName);
		System.out.println("Employee Address: " + empAddress);
		System.out.println("Employee Gender: " + empGender);
		System.out.println("Employee Age: " + empAge);
	}
}
