import java.util.Scanner;

public class Bob {
    public static void main(String[] args){
        // Bob is a lackadaisical teenager. In conversation, his responses are very limited.

        // Bob answers 'Sure.' if you ask him a question. (the input ends with a question mark)
        // He answers 'Whoa, chill out!' if you yell at him. (the input ends with an exclamation mark)
        // He says 'Fine. Be that way!' if you address him without actually saying anything. (empty input)
        // He answers 'Whatever.' to anything else.
        // Write the Java code necessary so that a user of your command line application can have a conversation with Bob.
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.print("ME > ");
            String r = s.nextLine();
            boolean q = r.endsWith("?"); //is it a question?
            boolean y = r.endsWith("!"); //is it a yell?
            boolean eq = r.isEmpty(); //is it an empty question

            if(q){
                System.out.println("BOB > Sure.");
            }else if(y){
                System.out.println("BOB > Whoa, chill out!");
            }else if(eq){
                System.out.println("BOB > Fine, Be that way!");
            }else {
                System.out.println("BOB > Whatever.");
            }


        }
    }
}
