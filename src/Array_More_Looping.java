import java.util.Random;
import java.util.Scanner;


public class Array_More_Looping {
    public static void main(String[] args) {
        //declare
        int ARRAY_SIZE = 100;
        int[] dataPoints;
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        //size
        dataPoints = new int[ARRAY_SIZE];
        //Initialize the data array to int values from 1-100
        for (int x = 0; x < dataPoints.length; x++) {
            dataPoints[x] = rnd.nextInt(100) + 1;
        }
        for (int x = 0; x < dataPoints.length; x++) {
            System.out.printf(dataPoints[x] + " " + "|" + " ");
        }
        System.out.println("");
        //sum
        int sum = sum(dataPoints);
        for (int x = 0; x < dataPoints.length; x++) {
            sum = sum + dataPoints[x];
        }
        // Average
        int ave = sum / dataPoints.length;
        System.out.println("The sum of the data set is " + sum);
        System.out.println("The average of the data set is " + ave);

        //linear scan
        int userValue = SafeInput.getRangedInt(in, "Enter an integer between 1 and 100: ", 1, 100);
        int count = 0;
        boolean foundTarget = contains(dataPoints,userValue);
        for (int x = 0; x < dataPoints.length; x++) {

            if (dataPoints[x] == userValue) {
                foundTarget = true;
                System.out.println("Found " + userValue + " at index " + x);
                count ++;
            }
        }
        if (!foundTarget) {
            System.out.println("Target " + userValue + " not found!");
        }

        foundTarget = false;
        System.out.println("The loop found the user's value within the array: " + count + " times");

        // short circuit search with break  Find First
        for (int x = 0; x < dataPoints.length; x++) {

            if (dataPoints[x] == userValue) {
                foundTarget = true;
                System.out.println("Breaking! Found " + userValue + " at index " + x);
                break;
            }
        }
        if (!foundTarget) {
            System.out.println("Target " + userValue + " not found!");
        }

        // min and max
        int min = min(dataPoints);
        int max = max(dataPoints);

        for (int x = 0; x < dataPoints.length; x++) {
            if (min > dataPoints[x]) {
                min = dataPoints[x];
            }
            if (max < dataPoints[x]) {
                max = dataPoints[x];
            }
        }
        System.out.println("The min is " + min);
        System.out.println("The max is " + max);

        // PART e
        double average = getAverage(dataPoints);
        System.out.println("Average of dataPoints is: " + average);
    }

    // part e
    public static double getAverage(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }

    // Extra credit
    public static int min(int[] values) {
        int min = values[0];
        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static int max(int[] values) {
        int max = values[0];
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int occurrenceScan(int[] values, int target) {
        int count = 0;
        for (int value : values) {
            if (value == target) {
                count++;
            }
        }
        return count;
    }

    public static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public static boolean contains(int[] values, int target) {
        for (int value : values) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }
}