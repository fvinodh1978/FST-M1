package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(1, "Red");
        myMap.put(2, "Blue");
        myMap.put(3, "Green");
        myMap.put(4, "Orange");
        myMap.put(5, "Black");
        //Print the elements in map before removal
        System.out.println("Size of Map is : " + myMap);
        //Remove an Element from Map
        myMap.remove(3);
        //Print the elements in map after removal
        System.out.println("Size of Map is : " + myMap);
        if (myMap.containsValue("Green")) {
            System.out.println("Map Contain Green");
        } else {
            System.out.println("Map doesnt Contain Green");
        }
        //Print the size of map
        System.out.println("Size of Map is : " + myMap.size());
    }
}
