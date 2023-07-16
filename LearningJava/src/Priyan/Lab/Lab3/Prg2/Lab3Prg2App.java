package Priyan.Lab.Lab3.Prg2;
import java.util.Scanner;
public class Lab3Prg2App {
	public static void main(String[] args) {
		double surfaceArea, volume, density;
		Scanner in = new Scanner(System.in);
		System.out.println("Choose one of the Shapes....");
		System.out.println(" 1) Sphere");
		System.out.println(" 2) HemiSphere");
		int choice = in.nextInt();
		if (choice == 1) {
			Sphere s1 = new Sphere();
			surfaceArea = s1.findSurfaceArea();
			volume = s1.findVolume();
			s1.displaySphere();
		}
		else {
			HemiSphere h1 = new HemiSphere();
			density = h1.findDensity();
			h1.displayHemiSphere();
		}
	}
}
