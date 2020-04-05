package com.training.shpakova;

public class BubbleSort implements Sorter {

    public void sort(int [] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 2; j >= 0; j--) {
                if (array[j + 1] < array[j]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

}
