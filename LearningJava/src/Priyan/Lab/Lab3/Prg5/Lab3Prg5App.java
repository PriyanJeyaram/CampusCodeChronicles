package Priyan.Lab.Lab3.Prg5;
import java.util.Scanner;
public class Lab3Prg5App {
	public static void main(String[] args) {
		int ch;
		Scanner in = new Scanner(System.in);
		System.out.println("...Menu...");
		System.out.println("1)Full Time Employee\n2)Part Time Employee");
		System.out.print("Enter Your Choice: ");
		ch = in.nextInt();
		if(ch == 1) {
			FullTimeEmployee fe1 = new FullTimeEmployee();
			fe1.displayFullTimeEmpDetails();
		} else {
			PartTimeEmployee pe1 = new PartTimeEmployee();
			pe1.displayPartTimeEmpDetails();
		}
	}
}
