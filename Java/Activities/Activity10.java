package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        //Create a Hashset
        HashSet<String> hs = new HashSet();
        //Add Six Elements
        hs.add("One");
        hs.add("Two");
        hs.add("Three");
        hs.add("Four");
        hs.add("Five");
        hs.add("Six");
        //Print original HashSet
        System.out.println("Original HashSet is :" + hs);
        //Print Size of HashSet
        System.out.println("Size of HashSet is :" + hs.size());
        //Remove an element
        hs.remove("Four");
        //Remove an element which doesnt Exists
        hs.remove("Seven");
        //Check if Seven Exists
        if (hs.contains("Seven")) {
            System.out.println("Seven Exists ");
        } else {
            System.out.println("Seven doesnt Exists ");
        }
        //Update set details
        System.out.println("Updated HashSet entries " + hs);
    }
}
