package Priyan.Lab.Lab2.Prg2.Student;

public class MedicalStudent extends Methods{
    String Name = setName();
    String College = setCollege();
    String Specialization = setSpecialization();
    public void display(){
        System.out.println("MedicalStudent\nName: " + Name + "\nCollege: " + College + "\nSpecialization: " + Specialization);
    }
}
