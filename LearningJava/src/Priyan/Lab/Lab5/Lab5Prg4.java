package Priyan.Lab.Lab5;
import java.util.Scanner;

class Test1 {
	int i;
	public void printNum() {
		System.out.println("Value of i: " + i);
	}
}
class Test2 extends Test1 {
	int j;
	public void printNum() {
		super.printNum();
		System.out.println("Value of j: " + j);
	}
}
public class Lab5Prg4 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		Test2 t2 = new Test2();
		System.out.println("...Data Entry...");
		System.out.print("Enter Value of i: ");
		t2.i = t.nextInt();
		System.out.print("Enter Value of j: ");
		t2.j = t.nextInt();
		System.out.println("...Printing the Values of i, j...");
		t2.printNum();
	}
}
