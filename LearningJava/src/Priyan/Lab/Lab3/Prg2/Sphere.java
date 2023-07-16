package Priyan.Lab.Lab3.Prg2;
import java.util.Scanner;

import static java.lang.Math.PI;

public class Sphere {
	/*
	* Class: Sphere
	* Attributes: Center, Radius
	* Methods: Surface Area, Volume
	* Constructor: Parameterized Constructor
	* Formulae:
	* 1) Surface Area: 4*PI*radius*radius
	* 2) Volume: (4/3)*PI*radius*radius*radius
	*/

	String center;
	double radius, surfaceArea, volume;
	Scanner t = new Scanner(System.in);
	Sphere(double r, String c) {
		radius = r;
		center = c;
	}
	Sphere() {
		System.out.print("Enter Co-ordinates of Center (x,y,z): ");
		center = t.nextLine();
		System.out.print("Enter Radius of Sphere: ");
		radius = t.nextInt();
	}
	public double findSurfaceArea() {
		surfaceArea = 4*PI*radius*radius;
		return surfaceArea;
	}
	public double findVolume() {
		volume = (4.0 / 3)*PI*radius*radius*radius;
		return volume;
	}
	public void displaySphere() {
		System.out.println("Center: " + center);
		System.out.println("Radius: " + radius);
		System.out.println("Surface Area: " + surfaceArea);
		System.out.println("Volume: " + volume);
	}
}
