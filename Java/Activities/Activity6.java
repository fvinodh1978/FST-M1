package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    Plane(int maxPassengers){
        this.maxPassengers=maxPassengers;
        this.passengers=new ArrayList<String>();
    }
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;
    public List<String> getPassengers() {
        return passengers;
    }

    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }

    public void onboard(String passenger){
        passengers.add(passenger);
    }

    public Date takeOff(){
        this.lastTimeTookOf = new Date();
        return this.lastTimeTookOf;
    }

    public void land(){
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }
}
public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        int maxPassengers=10;
        Plane plane = new Plane(maxPassengers);
        plane.onboard("Passenger1");
        plane.onboard("Passenger2");
        plane.onboard("Passenger3");
        plane.onboard("Passenger4");
        plane.onboard("Passenger5");
        plane.onboard("Passenger6");
        plane.onboard("Passenger7");
        plane.onboard("Passenger8");
        plane.onboard("Passenger9");
        plane.onboard("Passenger10");
        System.out.println("Plane took off at: " + plane.takeOff());
        System.out.println("People on the plane: " + plane.getPassengers());
        Thread.sleep(5000);
        plane.land();
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
    }
}
