package com.training.shpakova.task1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SorterTest {
    public static final int[] FIRST_ARRAY = {1, 12, 17, 70, 20};
    public static final int[] NULL_ARRAY = {};
    public static final int[] EXPECTED_ARRAY = {1, 20, 12, 70, 17};
    Sorter sorter;

    @Before
    public void init() {
        sorter = new Sorter();
    }

    @Test
    public void testSortByNumberSumForPositiveCase() {
        Assert.assertArrayEquals(EXPECTED_ARRAY, sorter.sortByNumberSum(FIRST_ARRAY));
    }

    @Test
    public void testSortByNumberSumForNullArg() {
        Assert.assertArrayEquals(NULL_ARRAY, sorter.sortByNumberSum(NULL_ARRAY));
    }

}