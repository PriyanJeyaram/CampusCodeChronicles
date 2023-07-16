package Priyan.Lab.Lab1;
/*
Que#3
Write a program to print the sum of all squares between 1 and N, where N is a number accepted from the
keyboard.
*/
import java.util.Scanner;
public class Lab1Prg3 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int sumOfSquares = 0;
        System.out.println("Enter a number:");
        int numOfEntries = obj.nextInt();
        for (int i =1; i <= numOfEntries; i++) {
            sumOfSquares += i * i;
        }
        System.out.println("Sum of all squares between 1 and " + numOfEntries + " is: " + sumOfSquares);
    }
}
