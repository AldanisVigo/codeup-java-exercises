import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class WedNov9 {

    public static void main(String[] args) {
        //    ToDo: save your age to a variable. create a scanner class. have the user guess your age. return whether or not the guessed age is the same as the age saved:
        int age = 32;
        int guess = -1;
        Scanner scan = new Scanner(System.in);
        while (guess != age) {
            System.out.print("What's my age?");
            guess = scan.nextInt();
            scan.nextLine();
            if (guess != age) {
                System.out.println("You guessed incorrectly!");
            }
        }

        System.out.println("You got it!");

    }
}
