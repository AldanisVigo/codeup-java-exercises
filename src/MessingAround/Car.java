package MessingAround;

public class Car {
    private int numberOfDoors;
    private String driveTrain;
    private int cillinders;

    public Car(int doors, String train, int cill){
        this.numberOfDoors = doors;
        this.driveTrain = train;
        this.cillinders = cill;
    }

    public void drive(){
        System.out.println("Keys turned, driving....");
    }
}
