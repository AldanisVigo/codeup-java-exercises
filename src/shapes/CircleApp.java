package shapes;

import util.Input;

import java.util.Scanner;

public class CircleApp {
    private static int numberOfCircles;
    public static void main(String[] args){
        Input input = new Input(new Scanner(System.in));
        do {
            double radii = input.getDouble(1.0, 10.0, "Please enter a radius for a circle between 0ft and 10ft without the units: ".describeConstable());
            Circle circle = new Circle(radii);
            System.out.printf("Circumference: %.4fft\n", circle.getCircumference());
            System.out.printf("Area: %.4f ft²\n", circle.getArea());
            numberOfCircles++;
        }while(input.yesNo("Would you like to create another circle?".describeConstable()));
        System.out.println("You created " + numberOfCircles + " circles!");
    }
}
