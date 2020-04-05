package com.training.shpakova;

public class SortingContext {
    private Sorter sortStrategy;

    public SortingContext(Sorter sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public boolean execute(int[] array) {
        boolean result = false;
        if (checkForElements(array)) {
            sortStrategy.sort(array);
            result = true;
        } else {
            System.out.println("Array doesn't contain elements");
        }
        return result;
    }

    private static boolean checkForElements(int [] inputArray) {
        return inputArray.length > 0;
    }

}
