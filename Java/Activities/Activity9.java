package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
    public static void main(String[] args) {
        //Create an ArrayList named myList of type String
        List<String> myList = new ArrayList<String>();
        //Add 5 names to the ArrayList using add() method.
        myList.add("Vinodh");
        myList.add("Franklin");
        myList.add("Suresh");
        myList.add("Reghu");
        myList.add("Jey");
        //print all the names using for loop.
        for (String name : myList) {
            System.out.println(name);
        }
        //use get() method to retrieve the 3rd name in the ArrayList.
        System.out.println(myList.get(2));
        //Use contains() method to check if a name exists in the ArrayList.
        if (myList.contains("Suresh")) {
            System.out.println("Name Suresh Exists ");
        } else {
            System.out.println("Name Suresh doesn't Exists ");
        }
        //Use size() method to print the number of names in the ArrayList.
        System.out.println("Size of Array List : " + myList.size());
        //Use remove() method to remove a name from the list and print the size() of the list again.
        //ArrayList before Removal
        System.out.println("Original Elements in Array List : " + myList);
        myList.remove("Jey");
        //ArrayList After Removal
        System.out.println("Elements in Array List After Removal : " + myList);
        System.out.println("Size of Array List : " + myList.size());
    }
}
