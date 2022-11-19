package shapes;

public class ShapesTest {
    // Test your code by creating a new class, ShapesTest (also inside of shapes) with a main method. Inside the
    // main method,
    public static void main(String[] args){
        //OLD CODE
//        // create a variable of the type Rectangle named box1 and assign it a new instance of the Rectangle class with
//        // a width of 4 and a length of 5
//        Rectangle box1 = new Rectangle(5,4);
//        // verify that the getPerimeter and getArea methods return 18 and 20, respectively.
//        System.out.println(" > Box 1's Area : " + box1.getArea());
//        System.out.println(" > Box 1's Perimeter : " + box1.getPerimeter());
//
//        // create a variable of the type Rectangle named box2 and assign it a new instance of the Square class that
//        // has a side value of 5.
//        Quadrilateral box2 = new Square(5);
//
//        // verify that the getPerimeter and getArea methods return 20 and 25, respectively.
//        System.out.println(" > Box 2's Area : " + box2.getArea());
//        System.out.println(" > Box 2's Perimeter : " + box2.getPerimeter());
//
//        // Re-run your ShapesTest class. How can you determine which getArea and getPerimeter methods are being
//        // called on each object?
//        // Answer: Add System.out.println on the getArea and getPerimeter methods of the classes.

//        declare a variable of the type Measurable named myShape.
        Measurable myShape = new Square(5);
        Measurable myShape2 = new Rectangle(10,20);

        System.out.printf("Shape 1 Area : %.2f\nShape 1 Perimeter : %.2f\n\n",myShape.getArea(), myShape.getPerimeter());
        System.out.printf("Shape 2 Area : %.2f\nShape 2 Perimeter : %.2f\n\n",myShape2.getArea(), myShape2.getPerimeter());

//        Answer the following questions:
//
//        Why does the code fail to compile if you leave off the getPerimeter method in Rectangle?
//          - Because we must implement every method in the Measurable interface. Including getPerimeter.

//        What happens if you try to call the getLength or getWidth methods of the myShape variable? Why?
//          - Because both the square and rectangle classes both provide a getter and setter for their fields, even the
//            ones inherited from the Quadrilateral class, the code works as expected.
    }
}
