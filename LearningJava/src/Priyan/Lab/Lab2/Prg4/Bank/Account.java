package Priyan.Lab.Lab2.Prg4.Bank;
import java.util.*;
public class Account {

    Scanner obj = new Scanner(System.in);

    private static int accId;
    private static double accBal;
    private static double annualInterestRate;
    private static Date dateCreated;

    //A no-arg constructor that creates a default account.
    Account() {
        System.out.print("\nEnter Account ID: ");
        accId = obj.nextInt();
        System.out.print("Enter Initial Balance: ");
        accBal = obj.nextDouble();
        System.out.print("Enter AnnualInterestRate: ");
        annualInterestRate = obj.nextDouble();
        dateCreated = new Date();
    }

    //A constructor that creates an account with the specified id and initial balance.
    Account(int aId, double aBal) {
        accId = aId;
        accBal = aBal;
    }

    //The accessor and mutator methods for id, balance, and annualInterestRate.
    //The accessor method for dateCreated.
    public static void access() {
        System.out.println("....Accessing Records....");
        System.out.println("Account Id is: " + accId);
        System.out.println("Account Balance is: " + accBal);
        System.out.println("Account AnnualInterestRate is: " + annualInterestRate);
        System.out.println("DateCreated is: " + dateCreated);
    }
    public void Mutator(String x) {
        if (x.equalsIgnoreCase("accBal")) {
            System.out.println("Old Balance is: " + accBal);
            System.out.println("Enter New  balance: ");
            accBal = obj.nextDouble();
            System.out.println("Updated Account Balance is: " + accBal);
        } else if (x.equalsIgnoreCase("annualInterestRate")) {
            System.out.println("Old AnnualInterestRate is: " + annualInterestRate);
            System.out.println("Enter New AnnualInterestRate: ");
            annualInterestRate = obj.nextDouble();
            System.out.println("Updated AnnualInterestRate is: " + annualInterestRate);
        }
        //access();
    }

    //A method named getMonthlyInterestRate() that returns the monthly interest rate.
    public static double getMonthlyInterestRate(double r) {
        return r/12;
    }

    //A method named getMonthlyInterest() that returns the monthly interest.
    public static double getMonthlyInterest(double r) {
        return (accBal*r)/100;
    }

    //A method named withdraw that withdraws a specified amount from the account.
    public static void withdraw(double d) {
        System.out.println("Old Balance is: " + accBal);
        System.out.println("Amount to be Withdrawn: " + d);
        if (d < accBal) {
            accBal -= d;
            System.out.println("Updated Account Balance is: " + accBal);
        }
        else {
            System.out.println("Withdrawal Amount exceeded");
        }
        //access();
    }

    //A method named deposit that deposits a specified amount to the account.
    public static void deposit(double d) {
        System.out.println("Old Balance is: " + accBal);
        System.out.println("Amount to be deposited: " + d);
        accBal += d;
        System.out.println("Updated Account Balance is: " + accBal);
        //access();
    }
}
