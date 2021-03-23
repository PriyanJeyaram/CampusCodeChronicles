package Priyan.Lab.Lab5;

class RBI {
	public double getInterestRate() { return 3.0; }
	public double getWithdrawal() { return 9_50_000.0; }
}

class SBI extends RBI {

	public double getInterestRate() {
		System.out.println("RBI Interest Rate: " + super.getInterestRate());
		return 6.0;
	}
	public double getWithdrawal() {
		System.out.println("RBI Withdrawal Amount: " + super.getWithdrawal());
		return 3_00_000.0;
	}
}

class ICICI extends RBI {
	public double getInterestRate() {
		System.out.println("RBI Interest Rate: " + super.getInterestRate());
		return 9.0;
	}
	public double getWithdrawal() {
		System.out.println("ICICI Withdrawal Amount: " + super.getWithdrawal());
		return 3_50_000.0;
	}
}
public class Lab5Prg3 {
	public static void main(String[] args) {
		SBI s1 = new SBI();
		ICICI i1 = new ICICI();
		System.out.println("...Displaying RBI vs SBI Details...");
		System.out.println("SBI Interest Rate: " + s1.getInterestRate());
		System.out.println("SBI Withdrawal Amount: " + s1.getWithdrawal());
		System.out.println("...Displaying RBI vs ICICI Details...");
		System.out.println("ICICI Interest Rate: " + i1.getInterestRate());
		System.out.println("ICICI Withdrawal Amount: " + i1.getWithdrawal());
	}
}
