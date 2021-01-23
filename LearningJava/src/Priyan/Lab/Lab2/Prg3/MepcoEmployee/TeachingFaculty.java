package Priyan.Lab.Lab2.Prg3.MepcoEmployee;

public class TeachingFaculty extends EmpMethods {
    String Name = setName();
    String Department = setDepartment();
    int Experience = setExperience();
    public void display(){
        System.out.println("TeachingFaculty\nName: " + Name + "\nDepartment: " + Department + "\nExperience: " + Experience);
    }
}
