package activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random indexGen = new Random();
        List<Integer> list = new ArrayList<Integer>();
        System.out.print("Enter the Number : ");
        while (scan.hasNextInt()) {
            System.out.print("Enter the Number : ");
            list.add(scan.nextInt());
        }
        Integer[] nums = list.toArray(new Integer[0]);
        int index = indexGen.nextInt(nums.length);
        System.out.println(index);
        index = indexGen.nextInt(nums.length);
        System.out.println(index);
        System.out.printf("Value at Index %d is %d ", index, nums[index]);
    }
}
