package Priyan.Lab.Lab2.Prg3.MepcoEmployee;
import java.util.Scanner;
public class EmpMethods {
    Scanner t = new Scanner(System.in);
    public String setName() {
        System.out.print("Enter Employee's Name: ");
        String name = t.next();
        return name;
    }
    public String setDepartment() {
        System.out.print("Enter Employee's Department: ");
        String dept = t.next();
        return dept;
    }
    public int setExperience() {
        System.out.print("Enter Employee's Experience: ");
        int xp = t.nextInt();
        return xp;
    }
    public int setAge() {
        System.out.print("Enter Employee's Name Age: ");
        int age = t.nextInt();
        return age;
    }
    public int setSalary() {
        System.out.print("Enter Employee's Salary: ");
        int sal = t.nextInt();
        return sal;
    }

}
