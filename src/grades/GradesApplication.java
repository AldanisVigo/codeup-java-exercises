package grades;

import util.Input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;

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

        Scanner myScanner = new Scanner(System.in);

        boolean outterloop = true;

        while(outterloop) {
            boolean loop = true;
            Student selectedStudent = null;
            while (loop) {
                // Print the list of GitHub usernames out to the console, and ask the user which student they would like
                // to see more information about.The user should enter a GitHub username (i.e. one of the keys in your map).
                System.out.println("Which student would you like to see more information about?");

                //Iterate through the student's key set
                for (Object studentId : students.keySet()) {
                    //Get the student that corresponds to the current key in the keyset
                    Student currentStudent = (Student) students.get(studentId);

                    //Print out the github username - and the user's name
                    System.out.printf("%s - %s\n", studentId, currentStudent.getName());
                }


                //Ask the user to enterthe username of the student they want more info about
                System.out.print("Type in the github id of the student you want more info about:");

                //Grab what they typed in
                String selectedStudentKey = myScanner.nextLine();

                // If the given input does not match up with a key in your map, tell the user that no users with that username
                // were found. If the given username does exist, display information about that student, including their name
                // and their grades.

                //Check if what they typed in is a key in the students map
                if (students.containsKey(selectedStudentKey)) {
                    selectedStudent = (Student) students.get(selectedStudentKey);
                    loop = false; //If it is, then stop looping.
                }
            }

            if (selectedStudent != null) {
                System.out.printf("%s's average grade is %f\n", selectedStudent.getName(), selectedStudent.getGradeAverage());

                // After the information is displayed, the application should ask the user if they want to continue,
                // and keep running so long as the answer is yes.
                Input myInput = new Input(myScanner);
                boolean wouldLikeToContinue = myInput.yesNo("Would you like to continue?".describeConstable());
                if(!wouldLikeToContinue){
                    outterloop = false;
                }
            }
        }
    }
}
