package Priyan.Lab.Lab4.Prg4;
import java.util.Scanner;

interface SalaryCompute {
	double computeSalary();
}

class HourlyWorker implements SalaryCompute {
	static int numberOfHrs, age, id;
	String name;
	Scanner t = new Scanner(System.in);

	public void getHourlyWorkerDetails() {
		System.out.println("...Hourly Worker Data Entry...");
		System.out.print("Enter Worker's ID: ");
		id = t.nextInt();
		System.out.print("Enter Worker's Name: ");
		name = t.next();
		System.out.print("Enter Worker's Age: ");
		age = t.nextInt();
		System.out.print("Enter #of Hours of Working: ");
		numberOfHrs = t.nextInt();
	}

	public void displayHourlyWorkerDetails() {
		System.out.println("...Displaying Hourly Worker Data...");
		System.out.println("Id : " + id);
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
		System.out.println("#of Working Hours : " + numberOfHrs);
	}

	@Override
	public double computeSalary() {
		return numberOfHrs * 60.0;
	}
}
class DailyWorker implements SalaryCompute {
	static int numberOfDays, age, id;
	String name;
	Scanner t = new Scanner(System.in);

	public void getDailyWorkerDetails() {
		System.out.println("...Daily Worker Data Entry...");
		System.out.print("Enter Worker's ID: ");
		id = t.nextInt();
		System.out.print("Enter Worker's Name: ");
		name = t.next();
		System.out.print("Enter Worker's Age: ");
		age = t.nextInt();
		System.out.print("Enter #of Days of Working: ");
		numberOfDays = t.nextInt();
	}

	public void displayDailyWorkerDetails() {
		System.out.println("...Displaying Daily Worker Data...");
		System.out.println("Id : " + id);
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
		System.out.println("#of Working Hours : " + numberOfDays);
	}

	@Override
	public double computeSalary() {
		return numberOfDays * 150.0;
	}
}
public class Lab4Prg4App {
	public static void main(String[] args) {

		Scanner t = new Scanner(System.in);
		int ch;
		do {
			System.out.println("...Menu...");
			System.out.print("1) Hourly Worker\n2) Daily Worker\nEnter Your Choice: ");
			ch = t.nextInt();
			if (ch == 1) {
				SalaryCompute sc = new HourlyWorker();
				HourlyWorker hw1 = new HourlyWorker();
				hw1.getHourlyWorkerDetails();
				hw1.displayHourlyWorkerDetails();
				double sal = sc.computeSalary();
				System.out.println("Salary: " + sal);
			} else if ( ch == 2 ) {
				SalaryCompute sc = new DailyWorker();
				DailyWorker dw1 = new DailyWorker();
				dw1.getDailyWorkerDetails();
				dw1.displayDailyWorkerDetails();
				double sal = sc.computeSalary();
				System.out.println("Salary: " + sal);
			} else {
				System.out.println("Enter a Choice between 1-2...");
			}
		}while(ch <= 2);

	}
}
