package Priyan.Lab.Lab3.Prg2;

public class HemiSphere extends Sphere{
	double mass, density;
	HemiSphere(double r, String c, double mass) {
		super(r, c);
		this.mass = mass;
	}
	HemiSphere() {
		super();
		System.out.print("Enter Mass: ");
		mass = t.nextDouble();
	}
	public double findDensity() {
		density = mass/volume;
		return density;
	}
	public void displayHemiSphere() {
		displaySphere();
		System.out.println("Mass: " + mass);
		System.out.println("Density: " + density);
	}
}
