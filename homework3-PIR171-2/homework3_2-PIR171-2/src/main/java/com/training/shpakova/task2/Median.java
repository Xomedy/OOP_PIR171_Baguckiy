package com.training.shpakova.task2;

import java.util.Arrays;


public final class Median {

    private Median() {
    }

    public static float median(int[] inputArray) {
        float median = 0;
        if (checkForElements(inputArray)) {
            int[] array = Arrays.copyOf(inputArray,inputArray.length);
            Arrays.sort(array);
            if (array.length % 2 == 0) {
                median = (float) (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
            } else {
                median = (float) array[array.length / 2];
            }
        } else {
            System.out.println("Array doesn't contain elements");
        }
        return median;
    }
    private static boolean checkForElements(int [] inputArray) {
        return inputArray.length > 0;
    }

    public static double median(double[] inputArray) {
        double median = 0;
        if (checkForElements(inputArray)) {
            double[] array = Arrays.copyOf(inputArray, inputArray.length);
            Arrays.sort(array);
            if (array.length % 2 == 0) {
                median = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
            } else {
                median = array[array.length / 2];
            }
        } else {
            System.out.println("Array doesn't contain elements");
        }
        return median;
    }

    private static boolean checkForElements(double [] inputArray) {
        return inputArray.length > 0;
    }

}
