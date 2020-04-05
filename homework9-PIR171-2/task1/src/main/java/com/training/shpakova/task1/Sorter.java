package com.training.shpakova.task1;

import java.util.*;

class Sorter {

    public int[] sortByNumberSum(int[] inputArray) {
        int[] result = {};
        if (checkForElements(inputArray)) {
            result = computeSorting(inputArray);
        } else {
            System.out.println("Array doesn't contain elements");
        }
        return result;
    }

    private int[] computeSorting(int[] inputArray) {
        int[] array = Arrays.copyOf(inputArray, inputArray.length);
        List<Integer> list = new ArrayList();
        for (int element : array) {
            list.add(element);
        }
        list.sort(COMPARE_BY_NUMBER_SUM);
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private boolean checkForElements(int[] inputArray) {
        return inputArray.length > 0;
    }

    private Comparator<Integer> COMPARE_BY_NUMBER_SUM = (one, other) -> countSum(one).compareTo(countSum(other));

    private Integer countSum(Integer number) {
        int integerSum = 0;
        for (char i : number.toString().toCharArray()) {
            if (i =! '-') {
                integerSum += Integer.valueOf(i);
            }
        }
        return integerSum;
    }

}


