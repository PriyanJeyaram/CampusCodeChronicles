package Priyan.Lab.Lab5;
import java.util.Scanner;

class Bank {
	public int getBalance() { return 0; }
}

class BankA extends Bank {
	@Override
	public int getBalance() { return 1000; }
}

class BankB extends Bank {
	@Override
	public int getBalance() { return 1500; }
}

class BankC extends Bank {
	@Override
	public int getBalance() { return 2000; }
}

public class Lab5Prg2 {
	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		int ch;
		BankA bA = new BankA();
		BankB bB = new BankB();
		BankC bC = new BankC();
		do {
			System.out.println("...Menu...");
			System.out.println("1) Bank-A\n2) Bank-B\n3) Bank-C\nEnter Your Choice: ");
			ch = t.nextInt();
			switch (ch) {
				case 1:
					System.out.println("Balance in Bank-A: " + bA.getBalance());
					break;
				case 2:
					System.out.println("Balance in Bank-B: " + bB.getBalance());
					break;
				case 3:
					System.out.println("Balance in Bank-C: " + bC.getBalance());
					break;
				default:
					System.out.println("Enter a Valid Option!");
			}
		}while(ch <= 3);
	}
}
