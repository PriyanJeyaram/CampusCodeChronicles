package Priyan.Lab.Lab2.Prg4.Bank;

public class Lab2Prg4App extends Account{
    public static void main(String[] args) {
        Account a1Obj = new Account();
        access();
        System.out.println("\nWithDraw Test: ");
        withdraw(2500);
        System.out.println("\nDeposit Test: ");
        deposit(3000);
        System.out.println("\nMonthly Interest: " + getMonthlyInterest(4.5) + "\n");
        access();
    }
}
