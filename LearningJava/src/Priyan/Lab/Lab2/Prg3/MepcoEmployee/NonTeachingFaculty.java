package Priyan.Lab.Lab2.Prg3.MepcoEmployee;

public class NonTeachingFaculty extends EmpMethods {
    String Name = setName();
    int Age = setAge();
    int Salary = setSalary();
    public void display(){
        System.out.println("NonTeachingFaculty\nName: " + Name + "\nAge: " + Age + "\nSalary: " + Salary);
    }
}
