package activities;

import java.util.Scanner;

public class Activity3 {
    //Declare Constants
    static final double earthFactor = 31557600;
    static final double merFactor = 0.2408467 * earthFactor;
    static final double venusFactor = 0.61519726 * earthFactor;
    static final double marsFactor = 1.8808158 * earthFactor;
    static final double jupiterFactor = 11.862615 * earthFactor;
    static final double saturnFactor = 29.447498 * earthFactor;
    static final double uranusFactor = 84.016846 * earthFactor;
    static final double neptuneFactor = 164.79132 * earthFactor;

    public static void main(String[] args) {
        Scanner ageScan = new Scanner(System.in);
        System.out.print("Enter the age : ");
        double age = ageScan.nextDouble();
        Scanner planetScan = new Scanner(System.in);
        System.out.print("Enter the Planet : ");
        String planetName = planetScan.nextLine();
        double myAge = 0;
        switch (planetName) {
            case "Mercury":
                myAge = (double) getAgeAtMercury(age);
                System.out.printf("Age at %s is %.2f", planetName, getAgeAtMercury(age));
                break;
            case "Venus":
                myAge = (double) getAgeAtVenus(age);
                System.out.printf("Age at %s is %.2f", planetName, getAgeAtVenus(age));
                break;
            case "Earth":
                myAge = (double) getAgeAtEarth(age);
                System.out.printf("Age at %s is %.2f", planetName, getAgeAtEarth(age));
                break;
            case "Mars":
                myAge = (double) getAgeAtMars(age);
                System.out.printf("Age at %s is %.2f", planetName, getAgeAtMars(age));
                break;
            case "Jupiter":
                myAge = (double) getAgeAtJupiter(age);
                System.out.printf("Age at %s is %.2f", planetName, getAgeAtJupiter(age));
                break;
            case "Saturn":
                myAge = (double) getAgeAtSaturn(age);
                System.out.printf("Age at %s is %.2f", planetName, getAgeAtSaturn(age));
                break;
            case "Uranus":
                myAge = (double) getAgeAtUranus(age);
                System.out.printf("Age at %s is %.2f", planetName, getAgeAtUranus(age));
                break;
            case "Neptune":
                myAge = (double) getAgeAtNeptune(age);
                System.out.printf("Age at %s is %.2f", planetName, getAgeAtNeptune(age));
                break;
            default:
                System.out.println("Entered Value is Invalid");
        }
    }

    public static double getAgeAtEarth(double age) {
        return age / earthFactor;
    }

    public static double getAgeAtMercury(double age) {
        return age / merFactor;
    }

    public static double getAgeAtVenus(double age) {
        return age / venusFactor;
    }

    public static double getAgeAtMars(double age) {
        return age / marsFactor;
    }

    public static double getAgeAtJupiter(double age) {
        return age / jupiterFactor;
    }

    public static double getAgeAtSaturn(double age) {
        return age / saturnFactor;
    }

    public static double getAgeAtUranus(double age) {
        return age / uranusFactor;
    }

    public static double getAgeAtNeptune(double age) {
        return age / neptuneFactor;
    }
}
