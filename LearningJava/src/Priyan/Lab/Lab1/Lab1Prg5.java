package Priyan.Lab.Lab1;
/*
Que#5
Write a Java method to display the first 50 pentagonal numbers.
 */
public class Lab1Prg5 {
    public static void main(String[] args) {
        System.out.println("Pentagonal Numbers: ");
        pentagonalNumber();
    }
    static void pentagonalNumber() {
        for (int i = 1; i < 51;) {
            for (int j = 0; j < 10; j++,  i++) {
                System.out.print(i*(i + 1) /2 + i*(i - 1) + " ");
            }
            System.out.println();
        }
    }
}
