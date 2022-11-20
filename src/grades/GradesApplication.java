package grades;

import util.Input;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GradesApplication {
//    Create a map for students and GitHub usernames
//
//    Create a class named GradesApplication with a main method.
//    Inside the main method, create a HashMap named students.
//    It should have keys that are strings that represent github usernames, and values that are Student objects.
//    Create at least 4 Student objects with at least 3 grades each, and add them to the map.
//
//    Be creative! Make up GitHub usernames and grades for your student objects.
    public static void printGrades(Student student){
        System.out.println("======================");
        System.out.println("======= Grades =======");
        System.out.println("======================");
        student.getGrades().forEach((grades)->{
            System.out.printf("%d\n",grades);
        });
        System.out.println();
    }

    public static String getMenuResponse(HashMap students,Scanner myScanner){
        // Print the list of GitHub usernames out to the console, and ask
        // the user which student they would like
        // to see more information about.The user should enter a GitHub
        // username (i.e. one of the keys in your map).
        System.out.println("Which student would you like to see more information about?");

        // Give an option to view all the students grades
        System.out.println("all - View all student's grades");
        System.out.println("printcsv - Print a csv of all student's grades.");
        System.out.println("classavg - View class average grade");

        //Iterate through the student's key set
        for (Object studentId : students.keySet()) {
            //Get the student that corresponds to the current key in the key set
            Student currentStudent = (Student) students.get(studentId);

            //Print out the GitHub username - and the user's name
            System.out.printf("%s - %s\n", studentId, currentStudent.getName());
        }


        //Ask the user to enter the username of the student they want more info about
        System.out.print(" >>> ");

        return myScanner.nextLine();
    }

    public static void askToContinue(Input myInput){
        //Escape the program if they choose to exit
        if(!myInput.yesNo("Would you like to continue?".describeConstable())){
            System.exit(0);
        };
    }

    public static void printDaysMissed(Student student){
        List<String> daysMissed = student.findDaysAbsent();
        System.out.println("================================");
        System.out.printf("======= Days Missed %d =========\n",daysMissed.size());
        System.out.println("================================");
        daysMissed.forEach((day)->System.out.printf("MISSED DAY: %s\n",day));
        System.out.println();
    }

    public static void displayStudentsData(HashMap students, Input myInput, String whatToDisplay){
        if(whatToDisplay.equals("grades")) {
            System.out.println("==================");
            System.out.println("Viewing All Grades");
            System.out.println("==================");

            //Iterate through the students
            students.forEach((key, student) -> {
                Student currentStudent = (Student) student; //Casting the student object to it's type
                //And printing out relevant student information
                System.out.printf(" ID: %s\t NAME: %s\t AVG: %.2f\t ATTDCE:%.2f\n",
                        key, currentStudent.getName(), currentStudent.getGradeAverage(),currentStudent.attendancePercentage());
                //Along with their grades table
                printGrades(currentStudent);
            });
        }else if(whatToDisplay.equals("classaverage")){ //If the user wants to see an average class grade
            //Accumulate the class's average grades
            double classAverageTotal = 0;
            for(Object studentObj : students.values()){
                Student student = (Student) studentObj;
                classAverageTotal += student.getGradeAverage();
            }

            //And calculate the average grade by dividing it by the number of students
            double classAverageGrade = classAverageTotal / students.values().size();

            //Print out the average class grade
            System.out.println("=============================");
            System.out.println("==== Average Class Grade ====");
            System.out.println("=============================");
            System.out.printf("Grade : %.2f\n\n", classAverageGrade);
        }else if(whatToDisplay.equals("csv")){
            System.out.println("=================================");
            System.out.println("===== Printing Students CSV =====");
            System.out.println("=================================");
            System.out.println("name,github_username,average_grade,attendance");

            //Iterate through the students
            students.forEach((key, student) -> {
                Student currentStudent = (Student) student; //Casting the student object to it's type
                //And printing out relevant student information
                System.out.printf("%s,%s,%.2f%%,%.2f%%\n",
                        currentStudent.getName(), key, currentStudent.getGradeAverage(),currentStudent.attendancePercentage() * 100);
                //Along with their grades table
//                printGrades(currentStudent);
            });
        }
        askToContinue(myInput);
    }
    public static void main(String[] args) {
        //Create a hashmap to store the students
        HashMap students = new HashMap<String,Student>();

        //Create student one
        Student s1 = new Student("Aldanis Vigo");
        s1.addGrade(10);
        s1.addGrade(30);
        s1.addGrade(50);

        //Add student one attendance
        s1.recordAttendance("2022-09-05","P");
        s1.recordAttendance("2022-09-06","A");
        s1.recordAttendance("2022-09-07","P");
        s1.recordAttendance("2022-09-09","A");

        //Create student two
        Student s2 = new Student("John Krsak");
        s2.addGrade(100);
        s2.addGrade(90);
        s2.addGrade(100);

        //Add student two attendance
        s2.recordAttendance("2022-09-05","A");
        s2.recordAttendance("2022-09-06","A");
        s2.recordAttendance("2022-09-07","P");
        s2.recordAttendance("2022-09-09","P");

        //Create student three
        Student s3 = new Student("Alvin McKenzie");
        s3.addGrade(90);
        s3.addGrade(99);
        s3.addGrade(100);

        //Add student one attendance
        s3.recordAttendance("2022-09-05","A");
        s3.recordAttendance("2022-09-06","P");
        s3.recordAttendance("2022-09-07","A");
        s3.recordAttendance("2022-09-09","P");

        //Create student four
        Student s4 = new Student("Mickey Mouse");
        s4.addGrade(100);
        s4.addGrade(39);
        s4.addGrade(30);

        //Add student four attendance
        s4.recordAttendance("2022-09-05","A");
        s4.recordAttendance("2022-09-06","A");
        s4.recordAttendance("2022-09-07","A");
        s4.recordAttendance("2022-09-09","A");

        //Add students 1 - 4 to the map of students
        students.put("aldanisvigo",s1);
        students.put("jkrsak",s2);
        students.put("alvinmckenzie",s3);
        students.put("mickeymouse",s4);


        //grab an instance of a scanner
        Scanner myScanner = new Scanner(System.in);

        //Grab an instance of the Input class
        Input myInput = new Input(myScanner);

        //Boolean to help us escape the outer loop
        boolean outerloop = true;
        boolean innerloop = true; //Boolean for the inner loop

        do {
            Student selectedStudent = null; //Placeholder for the selected student
            do {
                //Show the menu and wait for a response
                String selectedStudentKey = getMenuResponse(students,myScanner);

                // If the given input does not match up with a key in your map, tell the user that no users with
                // that username
                // were found. If the given username does exist, display information about that student,
                // including their name
                // and their grades.

                //Check if what they typed in is a key in the students map
                if(selectedStudentKey.equals("all")){
                    displayStudentsData(students,myInput,"grades");
                } else if(selectedStudentKey.equals("classavg")){
                    displayStudentsData(students,myInput,"classaverage");
                } else if(selectedStudentKey.equals("printcsv")){
                    displayStudentsData(students,myInput,"csv");
                } else if (students.containsKey(selectedStudentKey)) { //If they typed in a student id instead
                    selectedStudent = (Student) students.get(selectedStudentKey); //Cast the student down to it's type
                    innerloop = false; //Eject out of the loop
                }
            } while (innerloop);

            //Once we exit the loop
            if (selectedStudent != null) { //If a student was selected
                //Print out the user's average grade
                System.out.printf("%s's average grade is %f\n",
                        selectedStudent.getName(), selectedStudent.getGradeAverage());

                //BONUS : Display all the student's grades in addition to the grade average.
                printGrades(selectedStudent);

                System.out.printf("%s's average attendance is %f\n",
                        selectedStudent.getName(), selectedStudent.attendancePercentage() * 100);
                //Print days missed
                printDaysMissed(selectedStudent);

                // After the information is displayed, the application should ask the user if they want to continue,
                // and keep running so long as the answer is yes.
                boolean  wouldLikeToContinue = myInput.yesNo("Would you like to continue?".describeConstable());
                System.out.println("You answered " + wouldLikeToContinue);
                if(wouldLikeToContinue == false){
                    System.exit(0);
                }
                selectedStudent = null; //Clear the selected student
            }
        } while(outerloop); //As long as the outer loop boolean is true
    }
}
