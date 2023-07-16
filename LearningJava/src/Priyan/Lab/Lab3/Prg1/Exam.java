package Priyan.Lab.Lab3.Prg1;

public class Exam extends Student {

	static int[] marks = new int[6];

	public void getStudentMarks()  {
		System.out.println("...Mark Entry...");
		for (int i = 0 , j =1; i < 6; i++ , j++) {
			System.out.println("Mark " + j + " : ");
			marks[i] = t.nextInt();
		}
	}
}
