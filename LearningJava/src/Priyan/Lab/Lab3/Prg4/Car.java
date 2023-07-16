package Priyan.Lab.Lab3.Prg4;

public class Car extends MotorVehicle{
	double discountRate;
	Car() {
		super();
		System.out.print("Enter Discount Rate(in %): ");
		discountRate = t.nextDouble();
		discountRate %= 100;
	}
	public void provideDiscount() {
		double temp = modelPrice;
		temp *= 1_00_000;
		temp -= discountRate;
		temp /= 1_00_000;
		modelPrice = temp;
	}
	public void displayCarInfo() {
		displayModelInfo();
		System.out.println("Discount Rate: " + discountRate + "%");
	}
}
