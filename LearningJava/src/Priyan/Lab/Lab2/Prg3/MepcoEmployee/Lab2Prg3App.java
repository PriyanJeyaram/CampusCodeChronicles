package Priyan.Lab.Lab2.Prg3.MepcoEmployee;
import static java.lang.System.*;
import java.util.Scanner;
public class Lab2Prg3App {
    public static void main(String[] args) {
        Scanner sObj = new Scanner(in);
        out.println("Initialize TeachingFaculty");
        TeachingFaculty tObj = new TeachingFaculty();
        out.println("Initialize NonTeachingFaculty");
        NonTeachingFaculty nObj = new NonTeachingFaculty();
        out.println("Menu:\n 1)TeachingFaculty\n 2)NonTeachingFaculty\nEnter your Choice: ");
        int Choice = sObj.nextInt();
        if (Choice == 1) tObj.display();
        else if (Choice == 2) nObj.display();
        else out.println("Invalid Choice!!!");
    }
}
