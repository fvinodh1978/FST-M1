package activities;

import java.lang.reflect.Constructor;

public class Bicycle implements BicycleParts, BicycleOperations {
    public int gears;
    public int speed;

    public Bicycle(int gears, int speed){
        this.gears=gears;
        this.speed=speed;
    }
    public void applyBrake(int decrement){
        speed-=decrement;
        System.out.printf("Speed Reduced to %d\n", speed);
    }
    public void speedUp(int increment){
        speed+=increment;
        System.out.printf("Speed Increased to %d\n", speed);
    }

    public String bicycleDesc() {
        return ("Number of gears are " + gears + " and current speed is "+ speed);
    }
}

class MountainBike extends Bicycle{

    public int seatHeight;
    public MountainBike(int gears, int speed, int height) {
        super(gears, speed);
        seatHeight=height;
    }

    public String bicycleDesc() {
        return (super.bicycleDesc()+ "\nSeat height is " + seatHeight);
    }
}