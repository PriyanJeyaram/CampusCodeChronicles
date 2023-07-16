package Priyan.Lab.Lab3.Prg1;
import java.util.Scanner;
public class Student {

	Scanner t = new Scanner(System.in);
	static int rollNumber;
	static String Name;

	public void getStudentInfo() {
		System.out.println("...Register Student Basic Info...");
		System.out.println("Enter Student's Roll#: ");
		rollNumber = t.nextInt();
		System.out.println("Enter Student's Name: ");
		Name = t.next();
	}
}
