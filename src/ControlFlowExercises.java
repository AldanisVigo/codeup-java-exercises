public class ControlFlowExercises {
    public static void main(String[] args){
//        While
//
//        Create an integer variable i with a value of 5.
//        Create a while loop that runs so long as i is less than or equal to 15
//        Each loop iteration, output the current value of i, then increment i by one.
//        Your output should look like this:

//        5 6 7 8 9 10 11 12 13 14 15
        int i = 5;
        while(i <= 15){
            System.out.printf("%d ",i++);
        }

//        Create a do-while loop that will count by 2's starting with 0 and ending at 100. Follow each number with a new line.
//        Alter your loop to count backwards by 5's from 100 to -10.
//        Create a do-while loop that starts at 2, and displays the number squared on each line while the number is less than 1,000,000. Output should equal:
//
//        2
//        4
//        16
//        256
//        65536
        int p = 0;
        do {
            System.out.printf("%d\n", p);
            p += 2;
        }while(p <= 100);

        int r = 100;
        do {
            System.out.printf("%d\n", r);
            r -= 5;
        }while(r >= -10);


        double q = 2;
        do {
            System.out.printf("%.0f\n", q);
            q = Math.pow(q,2);
        }while(q < 1000000f);

        for(int f = 5; f <= 15; f++){
            System.out.printf("%d ",f);
        }

        for(int k = 0; k <= 100; k+=2){
            System.out.printf("%d \n",k);
        }

        for(int u = 100; u >= -10; u-=5){
            System.out.printf("%d \n",u);
        }

        int myNumber = 2;
        for(int t = 0; t < 5; t++){
            System.out.printf("%d \n",myNumber);
            myNumber *= myNumber;
        }
    }
}
