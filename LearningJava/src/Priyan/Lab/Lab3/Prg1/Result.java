package Priyan.Lab.Lab3.Prg1;

public class Result extends Exam {

	static int totalMarks = 0;

	public void getTotalMarks() {
		for (int i = 0 , j =1; i < 6; i++ , j++)
			totalMarks += marks[i];
	}

	public static void displayStudentDetails() {
		System.out.println("...Basic Info...");
		System.out.println("Name: " + Name);
		System.out.println("Roll#: " + rollNumber);
		for (int i = 0 , j =1; i < 6; i++ , j++)
			System.out.println("Mark " + j + " : " + marks[i]);
		System.out.println("Total: " + totalMarks);
	}
}
