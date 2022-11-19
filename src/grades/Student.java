package grades;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    //Field to keep track of the student's name
    private String name;

    //Field to keep track of student's grades
    private ArrayList<Integer> grades;

    //Constructor
    public Student(String name){
        this.name = name; //Set the name to the name passed into the instance constructor
        this.grades = new ArrayList<>(); //Initialize the grades as an empty ArrayList
    }


    // returns the student's name
    public String getName(){
        return this.name;
    }

    // adds the given grade to the grades property
    public void addGrade(int grade){
        this.grades.add(grade);
    }

    // returns the average of the students grades
    public double getGradeAverage(){
        int total = 0;
        for(int i = 0; i < this.grades.size(); i++){
            total += this.grades.get(i);
        }
        return total / this.grades.size();
    }

    public ArrayList<Integer> getGrades() {
        return this.grades;
    }

    // Test your Student class by creating a StudentTest class, adding a main method and creating Student objects.
    // Verify that you can add grades to each object, and that your getGradeAverage method correctly returns the
    // average of the student's grades.
    public static void main(String[] args){
        Student student = new Student("Aldanis");
        for(int i = 0; i < 10; i++) {
            System.out.printf("Adding %d points\n", 100 - (i * 5));
            student.addGrade(100 - (i * 5));
            System.out.println("GPA : " + student.getGradeAverage());
        }
    }
}
