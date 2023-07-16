package Priyan.Lab.Lab2.Prg2.Student;
import static java.lang.System.*;
import java.util.Scanner;
public class Lab2Prg2App {
    public static void main(String[] args) {
        Scanner sObj = new Scanner(in);
        out.println("Initialize Engineering Student");
        EngineeringStudent eObj = new EngineeringStudent();
        out.println("Initialize Medical Student");
        MedicalStudent mObj = new MedicalStudent();
        out.println("Menu:\n 1)EngineeringStudent\n 2)MedicalStudent\nEnter your Choice: ");
        int Choice = sObj.nextInt();
        if (Choice == 1) eObj.display();
        else if (Choice == 2) mObj.display();
        else out.println("Invalid Choice!!!");
    }
}
