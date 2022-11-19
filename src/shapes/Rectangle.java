package shapes;

public class Rectangle extends Quadrilateral implements Measurable{
    @Override
    public double getPerimeter() {
        return this.length * 2 + this.width * 2;
    }

    @Override
    public double getArea() {
        return this.length * this.width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    //Rectangle should define a constructor that accepts two numbers for length and width, and sets
    //those properties.
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }


////    Create two methods on the Rectangle class, getArea and getPerimeter that return the respective values. The
////    formulas for both follow:
//
//    public double getArea(){
//        System.out.println("getArea() -> Rectangle Class");
//        return length * width;
//    }
//
//    public double getPerimeter(){
//        System.out.println("getPerimeter() -> Rectangle Class");
//        return (2 * length) + (2 * width);
//    }
////
////    perimeter = 2 x length + 2 x width
////    area = length x width

}
