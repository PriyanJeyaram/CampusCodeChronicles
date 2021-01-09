package Priyan.Lab.Lab1;
/*
Que#2
Write a java program to take the students grade as an input argument and print the comments as follows.
100(Perfect Score), 90-99(Excellent),80-89(Good),70-79(above Average),60-69(Average),50-60(Below Average),0-
49(Not Passing).
*/
import java.util.Scanner;
public class Lab1Prg2 {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter Student Grade(0 to 100): ");
        int studentGrade = obj.nextInt();
        if (studentGrade < 50) {
            System.out.println("Not Passing");// 0 to 49
        } else if (studentGrade < 60) {
            System.out.println("Below Average");// 50 to 59
        } else if (studentGrade <70) {
            System.out.println("Average");// 60 to 69
        } else if (studentGrade < 80) {
            System.out.println("Above Average");// 70 to 79
        } else if (studentGrade < 90) {
            System.out.println("Good");// 80 to 89
        } else if (studentGrade < 100) {
            System.out.println("Excellent");// 90 to 99
        } else if (studentGrade == 100) {
            System.out.println("Perfect Score");// 100
        } else {
            System.out.println("Invalid Grade!!!");
        }
    }
}
