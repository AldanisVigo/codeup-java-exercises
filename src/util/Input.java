package util;

import java.util.Optional;
import java.util.Scanner;

//Create a package inside of src named util.
// Inside of util, create a class named Input
// that has a private field named scanner.
// When an instance of this object is created,
// the scanner field should be set to a new
// instance of the Scanner class. The class
// should have the following methods, all of
// which return command line input from the user:
public class Input {
    private Scanner scanner;

    public Input(Scanner myScanner){
        this.scanner = myScanner;
    }

    public String getString(){
        return this.scanner.nextLine();
    }

    public boolean yesNo(){
        //If there's a line available in the scanner's input stream
        if(this.scanner.hasNextLine()){
            String nextLine = this.scanner.nextLine(); //Grab it
            boolean isYes = nextLine.equalsIgnoreCase("yes"); //Check if it's yes
            boolean isY = nextLine.equalsIgnoreCase("y"); //Or y
            boolean isNo = nextLine.equalsIgnoreCase("no"); //Or no
            boolean isN = nextLine.equalsIgnoreCase("n"); // Or n
            if(isYes || isY) return true; //If it's yes or y return true
            else if(isNo || isN) return false; //Otherwise if it's no or n return false
            else return false; //Otherwise return false

            // If there's a boolean available in th scanner's input stream
        } else if(this.scanner.hasNextBoolean()) {
            return this.scanner.nextBoolean(); //Grab it and return it
        } else return false;
    }


    public int getInt(int min, int max, Optional<String> prompt){
        boolean inRange = false; //Flag to let us know we have input in range
        int nextInt = Integer.MIN_VALUE; //Start off with the minimum value available for ints
        while(!inRange){ //As long as our flag is still not set
            if(prompt != null) { //If the optional prompt string is present
                System.out.print(prompt.get()); //Get it and print it
            }
            else System.out.print("\nEnter a number: "); //Otherwise print the regular prompt
            if(scanner.hasNextInt()){ //And there's integers in the scanner's input stream
                nextInt = this.scanner.nextInt(); //Grab the next integer from the scanner
                this.scanner.nextLine(); //clear the \r \n characters off the input stream
                if(nextInt >= min && nextInt <= max){ //If the integer is in the range min-max
                    inRange = true; //Drop out of the loop
                }else{
                    System.out.println("Nah that's not in the range.");
                }
            }else this.scanner.nextLine(); //Clear the \r \n from the scanner's input stream
        }
        return nextInt;
    }

    public int getInt(Optional<String> prompt){
        return this.getInt(0,10,prompt);
    }

    public double getDouble(double min, double max,Optional<String> prompt){
        boolean inRange = false;
        double nextDouble = Double.MIN_VALUE;
        while(!inRange){
            if(prompt != null) { //If the optional prompt string is present
                System.out.print(prompt.get()); //Get it and print it
            }
            else System.out.print("\nEnter a decimal number: "); //Otherwise print the regular prompt
            if (scanner.hasNextDouble()) {
                nextDouble = this.scanner.nextDouble();
                this.scanner.nextLine(); //clear the \r \n characters off the scanner's input stream
                if(nextDouble >= min && nextDouble <= max){ //If the double is in range
                    inRange = true; //Exit condition has been met
                }else{
                    System.out.println("Nah that's not in the range.");
                }
            }else this.scanner.nextLine(); //Clear the \r \n from the scanner's input stream
        }
        return nextDouble;
    }

    public double getDouble(Optional<String> prompt){
        return this.getDouble(0.0,1.0,null);
    }


}
