package Priyan.Lab.Lab2.Prg1.Test;
import Priyan.Lab.Lab2.Prg1.Math.Calculations;
import java.util.Scanner;
public class Sample {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        Calculations obj1 = new Calculations();
        int choice;
        do {
            System.out.println("Enter 2# : ");
            int a = obj.nextInt();
            int b = obj.nextInt();
            System.out.print("Menu:\n 1)Addition\n 2)Subtraction\n 3)Multiplication\n 4)Division\nEnter your Choice: ");
            choice = obj.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Addition of 2# is: " + obj1.add(a,b));
                    break;
                case 2:
                    System.out.println("Subtraction of 2# is: " + obj1.sub(a,b));
                    break;
                case 3:
                    System.out.println("Multiplication of 2# is: " + obj1.mul(a,b));
                    break;
                case 4:
                    System.out.println("Division of 2# is: " + obj1.div(a,b));
                    break;
                default:
                    System.out.println("\nInvalid!!...Exit\n");
                }
            }while (choice < 5);
    }
}
