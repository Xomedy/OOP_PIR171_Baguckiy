package com.training.shpakova;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class SortingContextTest {
    public static final int [] SORTED_ARRAY = {0,1,2,3,7,8,9};
    public static final int [] NULL_ARRAY = {};
    public static final boolean FAILURE = false;
    public static final boolean SUCCESS = true;
    public static final Sorter SortStrategyBubble = new BubbleSort();
    public static final Sorter SortStrategySelection = new SelectionSort();
    SortingContext context;
    int[] array;

    @Before
    public void init() {
        array = new int[] {8, 0, 2, 3, 1, 7, 9};
    }

    @Test
    public void checkNullArray() {
        context = new SortingContext(SortStrategyBubble);
        assertEquals(FAILURE, context.execute(NULL_ARRAY));
    }

    @Test
    public void sortViaBubbleSort() {
        context = new SortingContext(SortStrategyBubble);
        assertEquals(SUCCESS, context.execute(array));
        assertArrayEquals(SORTED_ARRAY, array);
    }

    @Test
    public void sortViaSelectionSort() {
        context = new SortingContext(SortStrategySelection);
        assertEquals(SUCCESS, context.execute(array));
        assertArrayEquals(SORTED_ARRAY, array);
    }

}