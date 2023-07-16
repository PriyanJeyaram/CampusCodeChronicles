package Priyan.Lab.Lab2.Prg2.Student;
import java.util.Scanner;
public class Methods {
    Scanner t = new Scanner(System.in);
    public String setName() {
        System.out.print("Enter Student's Name: ");
        String name = t.next();
        return name;
    }
    public String setCollege() {
        System.out.print("Enter Student's College Name: ");
        String college = t.next();
        return college;
    }
    public String setSpecialization() {
        System.out.print("Enter Student's Specialization/Dept: ");
        String spl = t.next();
        return spl;
    }
}
