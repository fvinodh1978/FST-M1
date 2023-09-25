package activities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class Activity1 {
    static ArrayList list;
    @BeforeEach
    public void setup() {
        // Initialize a new ArrayList
        list = new ArrayList<String>();

        // Add values to the list
        list.add("alpha"); // at index 0
        list.add("beta"); // at index 1
    }

    @Test
    public void insertTest(){
        // First Assert if the length of list is 2
        assertEquals(2, list.size(), "Wrong Size");

        // Adding a 3rd Value and Assert if the new Length is 3
        list.add("gama");
        assertEquals(3, list.size(), "Wrong Size");

        // Assert Each element
        assertEquals("alpha", list.get(0), "Wrong Element");
        assertEquals("beta", list.get(1), "Wrong Element");
        assertEquals("gama", list.get(2), "Wrong Element");

    }
    @Test
    public void replaceTest(){
        // First Assert if the length of list is 2
        assertEquals(2, list.size(), "Wrong Size");

        // Adding a 3rd Value and Assert if the new Length is 3
        list.add("gamma");
        assertEquals(3, list.size(), "Wrong Size");

        // Replace  index 1 with Gamma
        list.set(1, "gana");

        // Assert Each element
        assertEquals("alpha", list.get(0), "Wrong Element");
        assertEquals("gana", list.get(1), "Wrong Element");
        assertEquals("gamma", list.get(2), "Wrong Element");
    }
}
