import java.util.Scanner;

public class ControlFlowExercises {
    public static void main(String[] args){
//        While
//
//        Create an integer variable i with a value of 5.
//        Create a while loop that runs so long as i is less than or equal to 15
//        Each loop iteration, output the current value of i, then increment i by one.
//        Your output should look like this:

//        5 6 7 8 9 10 11 12 13 14 15
        int i = 5;
        while(i <= 15){
            System.out.printf("%d ",i++);
        }

//        Create a do-while loop that will count by 2's starting with 0 and ending at 100. Follow each number with a new line.
//        Alter your loop to count backwards by 5's from 100 to -10.
//        Create a do-while loop that starts at 2, and displays the number squared on each line while the number is less than 1,000,000. Output should equal:
//
//        2
//        4
//        16
//        256
//        65536
        int p = 0;
        do {
            System.out.printf("%d\n", p);
            p += 2;
        }while(p <= 100);

        int r = 100;
        do {
            System.out.printf("%d\n", r);
            r -= 5;
        }while(r >= -10);


        double q = 2;
        do {
            System.out.printf("%.0f\n", q);
            q = Math.pow(q,2);
        }while(q < 1000000f);

        for(int f = 5; f <= 15; f++){
            System.out.printf("%d ",f);
        }

        for(int k = 0; k <= 100; k+=2){
            System.out.printf("%d \n",k);
        }

        for(int u = 100; u >= -10; u-=5){
            System.out.printf("%d \n",u);
        }

        int myNumber = 2;
        for(int t = 0; t < 5; t++){
            System.out.printf("%d \n",myNumber);
            myNumber *= myNumber;
        }

//      Fizzbuzz
//
//      One of the most common interview questions for entry-level programmers is the FizzBuzz test. Developed by Imran Ghory, the test is designed to assess basic looping and conditional logic skills.
//
//      Write a program that prints the numbers from 1 to 100.
//      For multiples of three: print “Fizz” instead of the number.
//      For the multiples of five: print “Buzz”.
//      For numbers which are multiples of both three and five: print “FizzBuzz”.
        for(int o = 1; o <= 100; o++){ //Iterate from 1 to 100.
            if((o % 3) == 0 && (o % 5 == 0)){ //If the current iteration number is divisible by 3 evenly.
                System.out.println("FizzBuzz"); //Say fizz.
            }else if((o % 5) == 0){ //If it's divisible by 5 evenly.
                System.out.println("Buzz"); //Say buzz.
            }else if((o % 3) == 0){
                System.out.println("Fizz");
            }else{ //Otherwise,
                System.out.println(o); //Print out the number by itself.
            }
        }

//        Display a table of powers.
//
//        Prompt the user to enter an integer.
//        Display a table of squares and cubes from 1 to the value entered.
//        Ask if the user wants to continue.
//        Assume that the user will enter valid data.
//        Only continue if the user agrees to.
//        Example Output
//
//
//        What number would you like to go up to? 5
//
//        Here is your table!
//
//        number | squared | cubed
//        ------ | ------- | -----
//        1      | 1       | 1
//        2      | 4       | 8
//        3      | 9       | 27
//        4      | 16      | 64
//        5      | 25      | 125

        boolean cont = true; //Loop condition
        while(cont) { //As long as the loop condition remains true

            //Prompt the user for what number they'd like to generate the powers table
            System.out.print("What number would you like to go up to?");

            //Create a scanner to read in the number
            Scanner myScanner = new Scanner(System.in);

            //Consume the integer
            int upTo = myScanner.nextInt();

            //Consume the newline character
            myScanner.nextLine();

            //Print out the powers table header
            System.out.println("number\t| squared\t| cubed");
            System.out.println("------\t| -------\t| -----");

            //Print out each number's row on the table
            for (int w = 1; w <= upTo; w++) {
                double square = Math.pow(w, 2); //Calculate the square
                double cube = Math.pow(w,3); //Calculate the cube
                //Format the row spacing and print
                System.out.format("%-6d\t| %-6.0f\t| %-6.0f\n", w, square, cube);
            }

            //Ask the user if they'd like to continue in the loop
            System.out.print("Would you like to continue (y/n): ");

            //Consume their answer
            String ans = myScanner.nextLine();

            //If their answer is yes ...
            //Otherwise
            //Exit the loop
            cont = ans.equalsIgnoreCase("y"); //Keep up true
        }
        System.out.println("Thanks for playing!");

//        Convert given number grades into letter grades.
//
//        Prompt the user for a numerical grade from 0 to 100.
//        Display the corresponding letter grade.
//        Prompt the user to continue.
//        Assume that the user will enter valid integers for the grades.
//        The application should only continue if the user agrees to.
//        Grade Ranges:
//
//        A+: 100 - 94
//        A : 93 - 92
//        A- : 91 - 88
//        B+ : 87 - 86
//        B :  85  -83
//        B- : 82 - 80
//        C+ : 79 - 76
//        C : 75 - 71
//        C- : 70 - 67
//        D+ : 66 - 65
//        D  :  64 - 63
//        D- :  62 - 60
//        F+ : 59 - 56
//        F  : 55 - 50
//        F- : 49 - 0

//        Edit your grade ranges to include pluses and minuses (ex: 99-100 = A+).


        cont = true;
        while(cont){
            //Prompt the user for a grade integer value between 0 and 100
            System.out.print("Please enter a grade between 0 and 100:");

            //Create a scanner to consume the integer
            Scanner myScanner = new Scanner(System.in);

            //Consume the integer
            int grade = myScanner.nextInt();

            //Consume the newline character
            myScanner.nextLine();

            //Calculate the letter grade
            if(grade <= 49 && grade >= 0){
                System.out.printf("Your grade is %s\n","F-");
            }else if(grade <= 55 && grade >= 50) {
                System.out.printf("Your grade is %s\n", "F");
            }else if(grade <= 59 && grade >= 56) {
                System.out.printf("Your grade is %s\n", "F+");
            }else if(grade <= 62 && grade >= 60) {
                System.out.printf("Your grade is %s\n", "D-");
            }else if(grade <= 64 && grade >= 63) {
                System.out.printf("Your grade is %s\n", "D");
            }else if(grade <= 66 && grade >= 65) {
                System.out.printf("Your grade is %s\n", "D+");
            }else if(grade <= 70 && grade >= 67) {
                System.out.printf("Your grade is %s\n", "C-");
            }else if(grade <= 75 && grade >= 71) {
                System.out.printf("Your grade is %s\n", "C");
            }else if(grade <= 79 && grade >= 76) {
                System.out.printf("Your grade is %s\b", "C+");
            }else if(grade <= 82 && grade >= 80) {
                System.out.printf("Your grade is %s\n", "B-");
            }else if(grade <= 85 && grade >= 83) {
                System.out.printf("Your grade is %s\n", "B");
            }else if(grade <= 87 && grade >= 86) {
                System.out.printf("Your grade is %s\n", "B+");
            }else if(grade <= 91 && grade >= 88) {
                System.out.printf("Your grade is %s\n", "A-");
            }else if(grade <= 93 && grade >= 92) {
                System.out.printf("Your grade is %s\n", "A");
            }else if(grade <= 100 && grade >= 94) {
                System.out.printf("Your grade is %s\n", "A+");
            }else{
                //This is not a valid grade between 0 and 100
                System.out.println("Invalid grade value");
            }

            //Ask the user if they would like to exit the loop or continue
            System.out.print("Would you like to continue (y/n) ?");
            String ans = myScanner.nextLine(); //Consume their answer

            //If they want to continue ...
            //Otherwise
            //Exit the loop
            cont = ans.equalsIgnoreCase("y"); //Keep us true
        }
        System.out.println("Thanks for checking grades and stuff!");
    }
}
