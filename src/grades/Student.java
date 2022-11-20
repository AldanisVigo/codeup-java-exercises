package grades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    //Field to keep track of the student's name
    private String name;

    //Field to keep track of student's grades
    private ArrayList<Integer> grades;

    private HashMap<String,String> attendance;

    //Constructor
    public Student(String name){
        this.name = name; //Set the name to the name passed into the instance constructor
        this.grades = new ArrayList<>(); //Initialize the grades as an empty ArrayList
        this.attendance = new HashMap<>(); //Initialize the attendance hashmap
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

        student.recordAttendance("2022-09-01","A");
        student.recordAttendance("2022-09-02","P");
        System.out.println(student.findDaysAbsent().size());
        System.out.printf("Attendance Percentage : %.2f",student.attendancePercentage());
    }

    /*
        Method to add attendance record to the attendance HashMap
    */
    public void recordAttendance(String date,String value){
        //Add a method named recordAttendance(String date, String value)
        // that adds records to the HashMap. This method should make sure
        // value is an acceptable string.

        if(date.equals(null) || value.equals(null)){ //If either of the required fields are not present
            System.out.println("You must provide a date in the format YYYY-MM-DD and a status P - Present or A - Absent");
        } else {
            this.attendance.put(date, value);
        }
    }

    //Create an instance method on your Student class to calculate a student's attendance percentage --
    // (Total Days - Absences) / Total Days.
    public double attendancePercentage(){
        int totalAbsent = 0;
        int totalPresent = 0;
        for(String attendanceValue : attendance.values()){
            if(attendanceValue.equals("A")){
                totalAbsent++;
            }else if(attendanceValue.equals("P")){
                totalPresent++;
            }
        }
        double percent = ((double) totalPresent / ((double) totalPresent + (double) totalAbsent));
        return percent;
    }

    // Create an instance method on Student that finds the specific days a student was absent.
    // This method should return a List of Strings, where each string is the date of the absence.
    public List<String> findDaysAbsent(){
        List<String> daysAbsent = new ArrayList<>();
        for(String date : this.attendance.keySet()) {
            String attendanceValue = this.attendance.get(date);
            if(attendanceValue.equals("A")){
                daysAbsent.add(date);
            }
        }
        return daysAbsent;
    }
}

