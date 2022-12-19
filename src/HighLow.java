import java.util.Scanner;

public class HighLow {

//    Game picks a random number between 1 and 100. --- DONE

//    Prompts user to guess the number. --- DONE

//    All user inputs are validated. --- DONE

//    If user's guess is less than the number, it outputs "HIGHER". --- DONE
//    If user's guess is more than the number, it outputs "LOWER". --- DONE
//    If a user guesses the number, the game should declare "GOOD GUESS!" --- DONE
//    Hints
//
//    Use the random method of the java.lang.Math class to generate a random number. --- DONE
//    Bonus
//
//    Keep track of how many guesses a user makes. --- DONE
//    Set an upper limit on the number of guesses. --- DONE

    private int randomNumber;
    private Scanner scanner;

    private int numberOfGuesses;

    private int maxGuesses;
    public HighLow(Scanner scanner){
        this.scanner = scanner;
        //Pick a random number between 1 and 100
        this.randomNumber = (int)(Math.random() * 100);
        this.numberOfGuesses = 0;
        this.maxGuesses = 10;
        startGuessingLoop();
    }

    private void startGuessingLoop(){
        boolean getOut = false;
        while(!getOut) {
            if(numberOfGuesses < maxGuesses) {
                Integer guess = null;
                while (guess == null) {
                    guess = askUserForNumber();
                }
                if (guess < this.randomNumber) {
                    System.out.println("HIGHER");
                } else if (guess > this.randomNumber) {
                    System.out.println("LOWER");
                } else {
                    //You found the number
                    System.out.println("GOOD GUESS!");
                    System.out.printf("The number I was thinking of is %d", this.randomNumber);
                    System.exit(0);
                }
                numberOfGuesses++;
            }else{
                System.out.println("You have ran out of guesses. Sorry!");
            }
        }
    }

    private Integer askUserForNumber(){
        System.out.print("Please enter a random number:");
        if(this.scanner.hasNextInt()) {
            return this.scanner.nextInt();
        }else{
            this.scanner.nextLine();
            return askUserForNumber();
        }
    }


    public static void main(String[] args){
        System.out.println("I am thinking of a number between 0 and 100. Please guess what it is.");
        Scanner newScanner = new Scanner(System.in);
        new HighLow(newScanner);
    }
}


