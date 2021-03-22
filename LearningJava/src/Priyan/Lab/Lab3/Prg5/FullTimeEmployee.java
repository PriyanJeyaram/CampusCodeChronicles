package Priyan.Lab.Lab3.Prg5;

public class FullTimeEmployee extends Employee{
	double empSalary;
	String empDesignation;
	FullTimeEmployee() {
		System.out.println("...Full Time Employee Data Entry...");
		System.out.println("Enter Employee Salary: ");
		empSalary = t.nextDouble();
		System.out.println("Enter Employee Designation: ");
		empDesignation = t.next();
	}
	public void displayFullTimeEmpDetails() {
		displayEmpDetails();
		System.out.println("Employee Salary: " + empSalary);
		System.out.println("Employee Designation: " + empDesignation);
	}
}
