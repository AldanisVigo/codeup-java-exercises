package MessingAround;

public class ExplainingPolymorphism {
    public static void main(String[] args){
        Car myHonda = new Honda(2,4);
        Honda myOtherHonda = new Honda(2,200);
        Honda myKidsHonda = new KidsHonda(2,30);
        Car myOtherKidsHonda = new KidsHonda(2,10);

        myHonda.drive();
        myOtherHonda.drive();
        myKidsHonda.drive();
        myOtherKidsHonda.drive();
    }
}
