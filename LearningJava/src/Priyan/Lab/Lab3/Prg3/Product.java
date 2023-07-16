package Priyan.Lab.Lab3.Prg3;
import java.util.Scanner;
public class Product {
	int productID;
	String productName;
	double productPrice;
	Scanner t = new Scanner(System.in);
	public void getProductDetails() {
		System.out.print("Enter Product ID: ");
		productID = t.nextInt();
		System.out.print("Enter Product Name: ");
		productName = t.next();
		System.out.print("Enter Product Price: ");
		productPrice = t.nextDouble();
	}
	public void displayProductDetails() {
		System.out.println("Product Id: " + productID);
		System.out.println("Product Name: " + productName);
		System.out.println("Product Price: " + productPrice);
	}
}
