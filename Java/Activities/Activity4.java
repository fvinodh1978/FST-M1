package activities;

import java.util.Arrays;

public class Activity4 {
    // Program to Sort an array of Integers
    public static void main(String[] args) {
        int[] numbers = { 9, 5, 1, 11, 90, 4, 3 , 99};
        System.out.println("Original Array " + Arrays.toString(numbers));
        for (int i =1; i<numbers.length; i++){
            int key=numbers[i];
            for(int j=0; j< i;j++){
                if(numbers[i]<numbers[j]){
                    for(int k=i; k>j;k--){
                        numbers[k]=numbers[k-1];
                    }
                    numbers[j]=key;
                    break;
                }
            }
        }
        System.out.println("Sorted Array " + Arrays.toString(numbers));
    }
}