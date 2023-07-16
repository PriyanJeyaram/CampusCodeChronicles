package Priyan.Lab.Lab3.Prg5;

public class PartTimeEmployee extends Employee{
	int workingHours;
	double ratePerHour;
	double pay;
	PartTimeEmployee() {
		System.out.println("...Part Time Employee Data Entry...");
		System.out.println("Enter Working Hours: ");
		workingHours = t.nextInt();
		System.out.println("Enter Rate per Hour: ");
		ratePerHour = t.nextDouble();
	}
	public void calculatePay() {
		pay = workingHours * ratePerHour;
	}
	public void displayPartTimeEmpDetails() {
		displayEmpDetails();
		System.out.println("Working Hours: " + workingHours);
		System.out.println("Rate Per Hour: " + ratePerHour);
		calculatePay();
		System.out.println("Amount Payable: " + pay);
	}
}
