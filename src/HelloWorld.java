public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Helloooo World!!");
        // Create an int variable named myFavoriteNumber and assign your favorite number to it, then print it out to the console.
        int myFavorityNumber = 2;
        System.out.println(myFavorityNumber);

        // Create a String variable named myString and assign a string value to it, then print the variable out to the console.

        String myString = "This be a string yo.";
        System.out.println(myString);

        // Change your code to assign a character value to myString. What do you notice?
//        myString = 'c'; //EXPLOSION

        //Change your code to assign the value 3.14159 to myString. What happens?
//        myString = 3.14159; //EXPLOSION

        //Declare an long variable named myNumber, but do not assign anything to it. Next try to print out myNumber to the console. What happens?
//        long myNumber;
//        System.out.println(myNumber); //EXPLOSION: java: reached end of file while parsing

        //Change your code to assign the value 3.14 to myNumber. What do you notice?
//        long myNumber = 3.14; //EXPLOSION : 3.14 is not a long

        //Change your code to assign the value 123L (Note the 'L' at the end) to myNumber.
//        long myNumber = 123L;

        //Change your code to assign the value 123 to myNumber.
//        long myNumber = 123;

        //Why does assigning the value 3.14 to a variable declared as a long not compile, but assigning an integer value does?
        /*
            Because 3.14 is a floating point number and cannot be assigned to a variable of type long. Assigning an integer works,
            because the integer value falls within the range of long numbers.
         */

        //Change your code to declare myNumber as a float. Assign the value 3.14 to it. What happens? What are two ways we could fix this?
//        float myNumber = 3.14; //EXPLOSION : must either be a cast from double to float or it must be tagged with the letter f for float
//        float myNumber = 3.14f; //Fix 1
//        float myNumber = (float) 3.14; //Fix 2

        //Copy and paste the following code blocks one at a time and execute them
//        int x = 5;
//        System.out.println(x++);
//        System.out.println(x);
//        int x = 5;
//        System.out.println(++x);
//        System.out.println(x);
//        What is the difference between the above code blocks? Explain why the code outputs what it does.
        /*
            The first block uses the value of x and then increments while the second block increments x and then uses the value.
         */
        //Try to create a variable named class. What happens?
//        int class = 10; //EXPLOSION: class is a reserved keyword duhh.

//        Object is the most generic type in Java. You can assign any value to a variable of type Object. What do you think will happen when the following code is run?
//        String theNumberThree = "three";
//        Object o = theNumberThree;
//        int three = (int) o;
        /*
            There will be an EXPLOSION because you're trying to cast the string into an integer (no-go)
         */
//        How is the above example different from the code block below?

//        int three = (int) "three"; //It's not you still can't cast the string to an integer
//        What are the two different types of errors we are observing?
        /*
            They pertain to incompatible types
         */
//        Rewrite the following expressions using the relevant shorthand assignment operators:
//        int x = 4;
//        x += 5;

//        int x = 3;
//        int y = 4;
//        y *= x;

//        int x = 10;
//        int y = 2;
//        x /= y;
//        y -= x;
//        What happens if you assign a value to a numerical variable that is larger (or smaller) than the type can hold? What happens if you increment a numeric variable past the type's capacity?

//        Hint: Integer.MAX_VALUE is a class constant (we'll learn more about these later) that holds the maximum value for the int type.
//        int i = 10000000000000000000;//EXPLOSION
          int maxInt = Integer.MAX_VALUE;
    }
}
