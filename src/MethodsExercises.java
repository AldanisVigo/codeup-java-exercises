import java.util.Scanner;

public class MethodsExercises {
    public static void main(String[] args){
        // Create a class named MethodsExercises. Inside of your class, write code to create the specified
        // methods. Test your code by creating a main method and calling each of the methods you've created.

        // Basic Arithmetic

        // Create four separate methods. Each will perform an arithmetic operation:
        // Addition
        System.out.printf("4 + 4 = %.2f\n", add(4.0,4.0));

        // Subtraction
        System.out.printf("4 - 4 = %.2f\n", sub(4.0,4.0));

        // Multiplication
        System.out.printf("4 * 4 = %.2f\n", mul(4.0,4.0));

        // Division
        System.out.printf("4 / 4 = %.2f\n", div(4.0,4.0));
        System.out.printf("4 / 0 = %.3s\n", div(4.0,0.0) != null ? div(4.0,0.0) : "ERR");

        // Each function needs to take two parameters/arguments so that the operation can be performed.
        // Test your methods and verify the output.
        // Add a modulus method that finds the modulus of two numbers.
        double themod = mod(4,1.5);
        System.out.format("Mod(4, 1.5) => %2s\n",themod);

        // Food for thought: What happens if we try to divide by zero? What should happen?
        // Create a method that validates that user input is in a certain range and returns that input as an integer
        // if it is within the given range. If not, prompt the user to input their number again until the input is
        // within range. The method signature should look like this:
        // public static int getInteger(int min, int max);
        // and is used like this:
        // System.out.print("Enter a number between 1 and 10: ");
        // int userInput = getInteger(1, 10);
        // If the input is invalid, prompt the user again.
        // Hint: recursion might be helpful here!
        int userInput = getInteger(1, 10);
        System.out.println();
        System.out.println(userInput);


        // Calculate the factorial of a number.
        // Prompt the user to enter an integer from 1 to 10.
        // Display the factorial of the number entered by the user.
        // Ask if the user wants to continue.
        // Use a for loop to calculate the factorial.
        // Assume that the user will enter an integer, but verify it’s between 1 and 10.
        // Use the long type to store the factorial.
        // Continue only if the user agrees to.
        // A factorial is a number multiplied by each of the numbers before it.
        // Factorials are denoted by the exclamation point (n!). Ex:


        // 1! = 1               = 1
        // 2! = 1 x 2           = 2
        // 3! = 1 x 2 x 3       = 6
        // 4! = 1 x 2 x 3 x 4   = 24

        boolean looping = true;

        while(looping) {
            System.out.print("Please enter a number between 1 and 10: ");
            Scanner myScanner = new Scanner(System.in);
            int myNumber = myScanner.nextInt();
            myScanner.nextLine();
            System.out.printf("%d! = ", myNumber);
            int nextFactorial = 1;
            for (int i = 1; i < myNumber; i++) {
                nextFactorial *= i;
                System.out.printf("%d x ", nextFactorial);
            }
            System.out.printf("%16s %d\n", "=", nextFactorial);
            System.out.println();
            System.out.print("Would you like to do another? (y/n) : ");
            String a = myScanner.nextLine();
            if(a.equalsIgnoreCase("y")){
                continue;
            }else{
                break;
            }
        }

    }

    //Add two doubles
    public static double add(double op1, double op2){
        return op1 + op2;
    }

    //Subtracts two doubles
    public static double sub(double op1, double op2){
        return op1 - op2;
    }

    //Multiplies two doubles
    //    Create your multiplication method without the * operator (Hint: a loop might be helpful).
    //    Do the above with recursion.
    //    public static double mul(double op1, double op2){
    //        return op1 * op2;
    //    }
    public static double mul(double a, double b){
        if( a == 0 || b == 0) return 0; //If either a or b is 0, then everything is 0
        else if(a == 1) return b; //If a is one return b
        else if(b == 1) return a; //If b is one return a
        else return b + mul(a -1, b); //Otherwise recurse until we get the answer
    }

    //Divides two doubled
    public static Number div(double op1, double op2){
        if(op2 == 0.0) return null;
        return op1 / op2;
    }

    //Returns the mod of two operands
    public static double mod(double op1, double op2){
        return op1 % op2;
    }


    //Create a method that validates that user input is in a certain range and returns that input as an integer if it
    // is within the given range. If not, prompt the user to input their number again until the input is within range.
    //The method signature should look like this:
    //public static int getInteger(int min, int max);
    //and is used like this:
    //System.out.print("Enter a number between 1 and 10: ");
    //int userInput = getInteger(1, 10);
    //If the input is invalid, prompt the user again.
    //Hint: recursion might be helpful here!
    public static int getInteger(int min, int max){
        System.out.printf("I'm thinking of a number in a certain range guess what it is:");
        Scanner myScanner = new Scanner(System.in);
        int input = myScanner.nextInt();
        myScanner.nextLine();
        if(input <= max && input >= min){
            System.out.printf("Congratulations the number %d is in the range %d to %d!",input,min,max);
        }else{
            System.out.println("Sorry that number is not in the range I'm thinking about.");
            getInteger(min,max);
        }
        return input;
    }
}
