package Priyan.Lab.Lab3.Prg3;

public class CD extends Product{
	String artistName;
	public void getCDDetails() {
		System.out.println("...Input CD Details...");
		getProductDetails();
		System.out.print("Enter Artist Name: ");
		artistName = t.next();
	}
	public void displayCD() {
		displayProductDetails();
		System.out.println("Artist Name: " + artistName);
	}
}
