package Priyan.Lab.Lab1;
/*
Que#1
Write a java program that calculates the total wages based on the number of hours worked. The wages are
calculated at a rate of 8.25 per hour for hours less than 40 and at the rate of 1.5 the standard rate for any hours
greater than 40. Number of hours is a command line argument to the program.
*/
import java.util.Scanner;
public class Lab1Prg1 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Number of Working Hours: ");
        int numberOfHrs = obj.nextInt();
        double totalWage;
        if (numberOfHrs < 40) {
            totalWage = 8.25 * numberOfHrs;
        } else {
            totalWage = 9.75 * numberOfHrs;
        }
        System.out.println("Total Wage :"+totalWage);
    }
}
