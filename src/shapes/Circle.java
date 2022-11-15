package shapes;

public class Circle {
    private double radius;
    private double area;
    private double circumference;

    public Circle(double r){
        this.radius = r;
        this.area = Math.PI * Math.pow(r,2);
        this.circumference = 2 * Math.PI * r;
    }

    //circumference = 2 x pi x radius
    //area = pi x (radius ^ 2)
    public double getArea(){
        return this.area;
    }

    public double getCircumference() {
        return this.circumference;
    }
}
