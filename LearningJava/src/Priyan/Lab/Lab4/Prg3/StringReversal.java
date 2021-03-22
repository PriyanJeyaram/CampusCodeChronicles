package Priyan.Lab.Lab4.Prg3;
import java.util.Scanner;

interface ReverseString {
	String reversal(String s);
}
public class StringReversal implements  ReverseString {
	@Override
	public String reversal(String s) {
		String temp = "";
		char [] charArr = s.toCharArray();
		int strLen = s.length();
		for (int i = strLen - 1 ; i >= 0 ; i--)
			temp += charArr[i];
		return temp;
	}

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		ReverseString rs = new StringReversal();
		System.out.println("Enter a String to be Reversed: ");
		String s = t.next();
		System.out.println("Old String: " + s);
		String reversedStr = rs.reversal(s);
		System.out.println("New String: " + reversedStr);
	}
}
