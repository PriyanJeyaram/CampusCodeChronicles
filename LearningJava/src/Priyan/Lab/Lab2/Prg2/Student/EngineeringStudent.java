package Priyan.Lab.Lab2.Prg2.Student;

public class EngineeringStudent extends Methods {
    String Name = setName();
    String College = setCollege();
    String Specialization = setSpecialization();
    public void display(){
        System.out.println("EngineeringStudent\nName: " + Name + "\nCollege: " + College + "\nDepartment: " + Specialization);
    }
}
