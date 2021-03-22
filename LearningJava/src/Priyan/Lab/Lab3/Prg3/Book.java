package Priyan.Lab.Lab3.Prg3;

public class Book extends Product{
	String authorName, publisherName, genre;
	public void getBookDetails() {
		System.out.print("Enter Author Name: ");
		authorName = t.next();
		System.out.print("Enter Publisher Name: ");
		publisherName = t.next();
		System.out.print("Enter Genre: ");
		genre = t.next();
	}
	public void displayBookDetails() {
		displayProductDetails();
		System.out.println("Author Name: " + authorName);
		System.out.println("Publisher Name: " + publisherName);
		System.out.println("Genre: " + genre);
	}
}
