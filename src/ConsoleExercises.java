import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ConsoleExercises {
    public static void main(String[] args){
        // Copy this code into your main method:
        double pi = 3.14159;
        // Write some Java code that uses the variable pi to output the following:
        // The value of pi is approximately 3.14.
        System.out.format("The value of pi is approximately %.2f",pi);
        // Prompt a user to enter a integer and store that value in an int variable using the nextInt method.
        Scanner myScanner = new Scanner(System.in);
        System.out.println("\n\n\n");
        System.out.print("Yo give me an int yo: ");
        int myInt = myScanner.nextInt();
        myScanner.nextLine();
        System.out.printf("You entered %d\n",myInt);
        // What happens if you input something that is not an integer?
        // EXPLOSION: Input Mismatch Exception
        // Prompt a user to enter 3 words, and store each of them in a separate variable. Then, display them back in the console, each on a newline.
        System.out.print("Please enter three words separated by a space: ");
        String firstWord = myScanner.next();
        String secondWord = myScanner.next();
        String thirdWord = myScanner.next();
        myScanner.nextLine();
        System.out.printf("Word One: %s\nWord Two: %s\nWord Three: %s",firstWord,secondWord,thirdWord);
        // What happens if you enter less than 3 words? EXPLOSION: Input Mismatch Exception
        // What happens if you enter more than 3 words? Only the first three are read by myScanner.next the rest are ignored.
        // Prompt a user to enter a sentence, then store that sentence in a String variable using the next method. Then, display that sentence back to the user.
        System.out.print("\n\nPlease enter a sentence:");
        // String mySentence = myScanner.next();
        // System.out.printf("Your sentence is: %s\n",mySentence);
        // do you capture all the words? //No only the first word
        // Rewrite the above example using the nextLine method.
        String mySentence = myScanner.nextLine();
        System.out.printf("Your sentence is: %s\n",mySentence);

        // Calculate the perimeter and area of the CodeUp classrooms
        // Prompt the user to enter values of length and width of a classroom at Codeup (or your room if virtual).
        System.out.print("Please enter the width of your room:");

        // Use the nextLine method each time you need to get user input. In this case, we need it twice, once to get
        // the user input for the length and again to get the user input for the width. Parse the resulting strings
        // to a numeric type.
        int roomWidth =  parseInt(myScanner.nextLine());
        System.out.print("\nYo enter the length of your room now: ");
        double roomLength = parseInt(myScanner.nextLine());

        //Assume that the rooms are perfect rectangles.
        // Assume that the user will enter valid numeric data for length and width.
        //Display the area and perimeter of that classroom.
        System.out.printf("\nYo the area of your room is %.2f and the perimeter of your room is : %.2f\n",
                roomWidth * roomLength,(2*roomLength) + (2*roomWidth));

        //The area of a rectangle is equal to the length times the width, and the perimeter of a rectangle is equal to 2 times the length plus 2 times the width.

    }
}
