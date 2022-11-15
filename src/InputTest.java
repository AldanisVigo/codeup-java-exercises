import util.Input;

import java.util.Scanner;

public class InputTest {
    public static void main(String[] args){
        //Create an instance of the input class
        Input input = new Input(new Scanner(System.in));

        //Let the user know we want a string
        System.out.print("Please enter a string:");

        //Call getString() on the instance
        System.out.printf("> Your String: %s\n",input.getString());

        //Let the user know we want a yes/no y/n true/false
        System.out.print("Yes or No? (true/false) | (y/n) | (yes/no):");

        //Call yesNo() on the instance
        System.out.printf("> Your Answer (y/n) %b\n",input.yesNo(null));

        //Let the use know we want an integer
        System.out.print("I'm thinking of an integer in a range, what is it? : ");

        //Call the getInt() method on the instance
        System.out.printf("> You got it! %d is in the range!\n",input.getInt(20,40,null));

        //Let the user know we want a decimal
        System.out.print("I'm thinking of a decimal in a range, what is it? : ");

        //Call the getDouble() method on the instance
        System.out.printf("> You got it! %.5f is in the range!\n",input.getDouble(20.0,40.0,"[CUSTOM PROMPT] Enter a double please:\n".describeConstable()));

        //Let the user know we want an integer again
        System.out.print("I'm thinking of an integer in a range, what is it? : ");

        //Call getInt() without parameters
        System.out.printf(" > You got it! %d is in the range\n",input.getInt("[CUSTOM PROMPT] Enter an int please:\n".describeConstable()));

        //Let the user know we want a decimal again
        System.out.print("I'm thinking of a decimal in a range, what is it? : ");

        //Call getDouble() without parameters
        System.out.printf(" > You got it %.5f is in the range\n", input.getDouble(null));


    }
}
