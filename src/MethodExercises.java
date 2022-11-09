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
        // Food for thought: What happens if we try to divide by zero? What should happen?
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
    public static double mul(double op1, double op2){
        return op1 * op2;
    }

    //Divides two doubled
    public static Number div(double op1, double op2){
        if(op2 == 0.0) return null;
        return op1 / op2;
    }
}
