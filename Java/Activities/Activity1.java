package activities;
class Car {
    Car() {
        this.tyres = 4;
        this.doors = 4;
    }

    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    public void displayCharacteristics() {
        System.out.println("Color of My Car is : " + this.color);
        System.out.println("Transmission Type of My Car is : " + this.transmission);
        System.out.println("make of My Car is : " + this.make);
        System.out.println("My Car have " + this.tyres + " Tyres");
        System.out.println("My Car have " + this.doors + " doors");
    }
    public void accelarate() {
        System.out.println("Car is moving forward.");
    }

    public void brake() {
        System.out.println("Car has stopped.");
    }
}

public class Activity1 {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.make = 2014;
        myCar.color = "Black";
        myCar.transmission = "Manual";
        myCar.displayCharacteristics();
        myCar.accelarate();
        myCar.brake();
    }
}
