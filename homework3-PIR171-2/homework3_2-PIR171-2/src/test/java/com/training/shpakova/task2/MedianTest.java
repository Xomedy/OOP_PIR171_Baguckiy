package com.training.shpakova.task2;

import org.junit.*;

public class MedianTest {

    @Test
    public void testIntMedian() {
        float result = Median.median(new int[]{5, 5, 5, 100, 5, 5, 5, 5});
        Assert.assertEquals(5, result, 0);
    }

    @Test
    public void testIntMedianOddNumber() {
        float result = Median.median(new int[]{1, 5, 2, 8, 7});
        Assert.assertEquals(5, result, 0);
    }

    @Test
    public void testIntMedianEvenNumber() {
        float result = Median.median(new int[]{1, 6, 2, 8, 7, 2});
        Assert.assertEquals(4, result, 0);
    }

    @Test
    public void testIntMedianEvenAverage() {
        float result = Median.median(new int[]{1, 2, 3, 4});
        Assert.assertEquals(2.5, result, 0);
    }

    @Test
    public void testDoubleMedian() {
        double result = Median.median(new double[]{1, 0.5, 0.5, 0.5, 0.5, 0.55, 0.5, 0.5});
        Assert.assertEquals(0.5, result, 0);
    }

    @Test
    public void testDoubleMedianOddNumber() {
        double result = Median.median(new double[]{0.5, 0.2, 0.4, 0.3, 0.1});
        Assert.assertEquals(0.3, result, 0);
    }

    @Test
    public void testDoubleMedianEvenAverage() {
        double result = Median.median(new double[]{0.1, 0.2, 0.3, 0.4, 0.2, 0.5});
        Assert.assertEquals(0.25, result, 0);
    }

    @Test
    public void testNullArgumentInIntMedian() {
        double result = Median.median(new int[]{});
        Assert.assertEquals(0, result, 0);
    }

    @Test
    public void testNullArgumentInDoubleMedian() {
        double result = Median.median(new double[]{});
        Assert.assertEquals(0, result, 0);
    }

}
