package shapes;

public class Square extends Quadrilateral {
    public Square(double i) {
        this.length = i;
        this.width = i;
    }


//    // Create a class named Square, also inside of shapes, that extends Rectangle. Square should define a constructor
//    // that accepts one argument, side, and calls the parent's constructor to set both the length and width to the
//    // value of side.
//    public Square(double side){
//        super(side,side);
//    }
//
//    // In the Square class, override the getArea and getPerimeter methods with the following definitions for a square
//
//    // perimeter = 4 x side
    @Override
    public double getPerimeter(){
//        System.out.println("getPerimeter() -> Square Class");
        return 4 * this.length;
    }

    public double getLength(){
        return this.length;
    }

    public double getWidth(){
        return this.width;
    }
//
//    // area = side ^ 2
    @Override
    public double getArea() {
//        System.out.println("getArea() -> Square Class");
        return Math.pow(this.length,2);
    }
}
