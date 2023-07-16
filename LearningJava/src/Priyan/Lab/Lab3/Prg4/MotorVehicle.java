package Priyan.Lab.Lab3.Prg4;
import java.util.Scanner;
public class MotorVehicle {
	Scanner t = new Scanner(System.in);
	String modelName;
	int modelNumber;
	double modelPrice;
	MotorVehicle() {
		System.out.println("...Data Entry...");
		System.out.print("Enter Model Name: ");
		modelName = t.next();
		System.out.print("Enter Model #: ");
		modelNumber = t.nextInt();
		System.out.print("Enter Model Price(in Lakhs): ");
		modelPrice = t.nextDouble();
	}
	public void displayModelInfo() {
		System.out.println("Model Name: " + modelName);
		System.out.println("Model #: " + modelNumber);
		System.out.println("Model Price: " + modelPrice + "L");
	}
}
