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

    public String getString(String prompt){
        System.out.print(prompt);
        return this.scanner.nextLine();
    }

    Optional<String> myOptional = null;

    public boolean yesNo(Optional<String> prompt){
        if(prompt != null){
            System.out.print("\n" + prompt.get());
        }
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
                System.out.print("\n" + prompt.get()); //Get it and print it
            }
            else System.out.print("\nEnter a number: "); //Otherwise print the regular prompt
            if(scanner.hasNextInt()){ //And there's integers in the scanner's input stream
                nextInt = this.scanner.nextInt(); //Grab the next integer from the scanner
                this.scanner.nextLine(); //clear the \r \n characters off the input stream
                if(nextInt >= min && nextInt <= max){ //If the integer is in the range min-max
                    inRange = true; //Drop out of the loop
                }else{
                    System.out.println("> Nah that's not in the range.");
                }
            }else this.scanner.nextLine(); //Clear the \r \n from the scanner's input stream
        }
        return nextInt;
    }

    // Improve your Input class.

    // Your getInt and getDouble methods should make sure that the value returned
    // from the method is actually an int or a double. You can do this by replacing
    // the use of the Scanner nextInt() and nextDouble() methods with the existing
    // getString() method you created in a previous exercise using the following methods
    // to convert the returned String into the desired datatype:

    // Integer.valueOf(String s);
    // Double.valueOf(String s);
    // Note these methods will throw a NumberFormatException if the given input cannot
    // be parsed as an int or double. Your methods on the Input class should handle these
    // exceptions, you can use a try-catch for this.

    // Bonus

    // Research the .valueOf method on the Integer class. You will find that it can also be
    // used to parse integers in different bases. Use this functionality to create two new
    // methods, getBinary and getHex that will accept a string that is a number in binary or hexadecimal.

    // Enter a binary number: 111
    // Your number is 7

    // Enter a hexidecimal number: 10
    // Your number is 16

    public int getInt(Optional<String> prompt){
        //TODO: Update code to use try catch

        if(prompt != null){
            System.out.print(prompt.get());
        }
        //Old code
        // if(this.scanner.hasNextInt()) {
        //  int myInt = this.scanner.nextInt();
        //  scanner.nextLine();
        //  return myInt;
        //}else{
        //  scanner.nextLine();
        //  return Integer.MIN_VALUE;
        //}
        int myInt = Integer.MIN_VALUE;
        try {
            myInt = Integer.valueOf(this.getString());
            return myInt;
        } catch(NumberFormatException e){
            //Let the user know there was a problem
            System.out.println(e.getMessage());

            //Try again.
            return this.getInt(prompt);
        }
    }

    public Integer getBinary(String bin){
        int binInt = Integer.MIN_VALUE;
        try{
            binInt = Integer.valueOf(bin,2);
            return binInt;
        }catch(NumberFormatException e){
            //Show the error message to the user
            throw e;
        }
    }

    public Integer getHex(String hex){
        int hexInt = Integer.MIN_VALUE;
        try{
            hexInt = Integer.valueOf(hex,16);
            return hexInt;
        }catch(NumberFormatException e){
            //Show the error message to the user
            throw e;
        }
    }

    public double getDouble(double min, double max,Optional<String> prompt){
        boolean inRange = false;
        double nextDouble = Double.MIN_VALUE;
        while(!inRange){
            if(prompt != null) { //If the optional prompt string is present
                System.out.print("\n" + prompt.get()); //Get it and print it
            }
            else System.out.print("\nEnter a decimal number: "); //Otherwise print the regular prompt
            //Old code
//            if (scanner.hasNextDouble()) {
//                nextDouble = this.scanner.nextDouble();
//                this.scanner.nextLine(); //clear the \r \n characters off the scanner's input stream
//                if(nextDouble >= min && nextDouble <= max){ //If the double is in range
//                    inRange = true; //Exit condition has been met
//                }else{
//                    System.out.println("> Nah that's not in the range.");
//                }
//            }else this.scanner.nextLine(); //Clear the \r \n from the scanner's input stream
            //New Code
            try{
                nextDouble = Double.valueOf(this.getString());
            }catch(NumberFormatException e){
                //Let the user know there was a problem
                System.out.println(e.getMessage());
                this.scanner.nextLine(); //Clear the scanner's input stream
            }
        }
        return nextDouble;
    }

    public double getDouble(Optional<String> prompt){
        return this.getDouble(0.0,1.0,null);
    }


    public static void main(String[] args) {
        Input myInput = new Input(new Scanner(System.in));
        System.out.print("Please enter a number in HEX and I'll tell you what it is in DEC:");
        Integer myHexNum = myInput.getHex(myInput.getString());
        System.out.printf("Your BIN number in DEC is  : %d\n",myHexNum);
        System.out.print("Please enter a number in BIN and I'll tell you what it is in DEC:");
        Integer myBinNum = myInput.getBinary(myInput.getString());
        System.out.printf("Your BIN number in DEC is : %d\n",myBinNum);

    }
}
