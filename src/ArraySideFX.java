import java.util.Scanner;

public class ArraySideFX {
    public static void main(String[] args) {
        int[] myArrayOne = new int[5];
        int[] myArrayTwo = myArrayOne;  // copied with assignment operator - same address on heap
        int[] myArrayThree = myArrayOne.clone();  // copied with clone - makes new address on heap
        myArrayTwo[0] = 7;
        System.out.println(myArrayOne[0]);
        System.out.println("address of myArrayOne: " + myArrayOne);
        System.out.println("address of myArrayTwo: " + myArrayTwo);
        System.out.println("address of myArrayThree: " + myArrayThree);
//        var i = 10;
        var something = new Scanner(System.in);
        System.out.println(something);
        System.out.println(something.getClass().getName());
    }
}