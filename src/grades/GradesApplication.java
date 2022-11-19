package grades;

import java.util.ArrayList;
import java.util.HashMap;

public class GradesApplication {
//    Create a map for students and GitHub usernames
//
//    Create a class named GradesApplication with a main method.
//    Inside the main method, create a HashMap named students.
//    It should have keys that are strings that represent github usernames, and values that are Student objects.
//    Create at least 4 Student objects with at least 3 grades each, and add them to the map.
//
//    Be creative! Make up GitHub usernames and grades for your student objects.
    public static void main(String[] args) {
        //Create a hashmap to store the students
        HashMap students = new HashMap<String,Student>();

        //Create student one
        Student s1 = new Student("Aldanis Vigo");
        s1.addGrade(10);
        s1.addGrade(30);
        s1.addGrade(50);

        //Create student two
        Student s2 = new Student("John Krsak");
        s2.addGrade(100);
        s2.addGrade(90);
        s2.addGrade(100);

        //Create student three
        Student s3 = new Student("Alvin McKenzie");
        s3.addGrade(90);
        s3.addGrade(99);
        s3.addGrade(100);

        //Create student four
        Student s4 = new Student("Mickey Mouse");
        s4.addGrade(100);
        s4.addGrade(39);
        s4.addGrade(30);

        //Add students 1 - 4 to the map of students
        students.put("aldanisvigo",s1);
        students.put("jkrsak",s2);
        students.put("alvinmckenzie",s3);
        students.put("mickeymouse",s4);
    }
}
