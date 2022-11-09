import static java.lang.Double.parseDouble;

public class MethodExercises {
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
}
