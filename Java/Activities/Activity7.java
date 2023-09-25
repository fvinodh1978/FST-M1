package activities;

public class Activity7 {
    public static void main(String[] args) {
        MountainBike mb = new MountainBike(4, 10, 4);
        System.out.println(mb.bicycleDesc());
        System.out.println("Speeding up...");
        mb.speedUp(2);
        System.out.println(mb.bicycleDesc());
        System.out.println("Slowing down...");
        mb.applyBrake(4);
        System.out.println(mb.bicycleDesc());
        mb.applyBrake(4);
        System.out.println(mb.bicycleDesc());
    }
}
