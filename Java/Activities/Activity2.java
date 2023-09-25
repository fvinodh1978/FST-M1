package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] myArray = {10, 77, 10, 54, -11, 10};
        int searchValue = 10;
        int targetValue = 30;
        boolean result = evaluate(myArray, searchValue, targetValue);
        if (result) {
            System.out.println("Yes the sum of 10s is " + targetValue);
        } else {
            System.out.println("No the sum of 10s is Not " + targetValue);
        }

    }

    private static boolean evaluate(int[] myArray, int searchNum, int targetValue) {
        int sum = 0;
        boolean result = true;
        for (int num : myArray) {
            if (num == searchNum) {
                sum += num;
            }
        }
        if (sum != targetValue) {
            result = false;
        }
        return result;
    }
}
