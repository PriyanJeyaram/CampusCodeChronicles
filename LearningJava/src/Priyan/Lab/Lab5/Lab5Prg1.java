package Priyan.Lab.Lab5;
import java.util.Scanner;

class Degree {
	public void getDegree() {
		System.out.println("I got a Degree!");
	}
}

class UnderGraduate extends Degree {
	@Override
	public void getDegree() {
		super.getDegree();
		System.out.println("I am an UnderGraduate!");
	}
}

class PostGraduate extends Degree {
	@Override
	public void getDegree() {
		super.getDegree();
		System.out.println("I am a PostGraduate!");
	}
}

public class Lab5Prg1 {
	public static void main(String[] args) {
		int ch;
		Scanner t = new Scanner(System.in);
		UnderGraduate ug1 = new UnderGraduate();
		PostGraduate pg1 = new PostGraduate();
		do {
			System.out.println("...Menu...");
			System.out.println("1) UnderGraduate\n2) PostGraduate\nEnter your choice: ");
			ch = t.nextInt();
			if(ch == 1) {
				ug1.getDegree();
			} else if (ch == 2){
				pg1.getDegree();
			} else {
				System.out.println("Enter a Valid Option");
			}
		}while(ch <= 2);
	}
}
