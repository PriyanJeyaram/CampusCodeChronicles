package Priyan.Lab.Lab1;
/*
Que#4
Write a interactive program using two dimensional arrays to perform matrix addition and subtraction. The program
asks the user to input the number of rows and columns for matrix A and matrix B. The user then enters the element
of each array. The program should display the sum of matrices A and B, and the difference of matrices A and B.
*/
import java.util.Scanner;
public class Lab1Prg4 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int R1, R2, C1, C2;
        //Get input for R1,C1
        System.out.println("Enter #of Rows & #of Cols for matrixOne:");
        R1 = obj.nextInt();
        C1 = obj.nextInt();
        //Get input for R2, C2
        System.out.println("Enter #of Rows & #of Cols for matrixTwo:");
        R2 = obj.nextInt();
        C2 = obj.nextInt();
        int[][] matrixOne = new int[R1][C1];
        int[][] matrixTwo = new int[R2][C2];
        if (R1 == R2 && C1 == C2) {
            System.out.println("Enter Elements for matrixOne:");
            for (int i = 0; i < R1; i++) {
               for (int j = 0; j < C1; j++) {
                   matrixOne[i][j] = obj.nextInt();
               }
            }
            System.out.println("Enter Elements for matrixTwo:");
            for (int i = 0; i < R2; i++) {
                for (int j = 0; j < C2; j++) {
                    matrixTwo[i][j] = obj.nextInt();
                }
            }
            //Perform Addition and Subtraction
            System.out.println("Addition of matrices:\n");
            for (int i = 0; i < R1; i++) {
                for (int j = 0; j < C1; j++) {
                    System.out.print(" " + (matrixOne[i][j] + matrixTwo[i][j]) + " ");
                }
                System.out.println();
            }
            System.out.println("Subtraction of matrices:\n");
            for (int i = 0; i < R1; i++) {
                for (int j = 0; j < C1; j++) {
                    System.out.print(" " + (matrixOne[i][j] - matrixTwo[i][j]) + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Rows and columns must be same to manipulate!!!");

        }
    }
}
