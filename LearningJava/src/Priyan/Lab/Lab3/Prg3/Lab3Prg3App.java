package Priyan.Lab.Lab3.Prg3;

public class Lab3Prg3App {
	public static void main(String[] args) {
		Scientific s1 = new Scientific();
		CD cd1 = new CD();
		cd1.getCDDetails();
		System.out.println("...Displaying Scientific Book...");
		s1.displayBookDetails();
		System.out.println("...Displaying CD Details...");
		cd1.displayCD();
	}
}
