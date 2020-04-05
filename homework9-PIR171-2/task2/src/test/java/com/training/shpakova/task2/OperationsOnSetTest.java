package com.training.shpakova.task2;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import java.util.Arrays;
import java.util.HashSet;

public class OperationsOnSetTest {
    public static final HashSet FIRST_SET = new HashSet<>(Arrays.asList("A", "B"));
    public static final HashSet SECOND_SET = new HashSet<>(Arrays.asList("B", "C"));
    public static final HashSet UNION = new HashSet<>(Arrays.asList("A", "B", "C"));
    public static final HashSet INTERSECTION = new HashSet<>(Arrays.asList("B"));
    public static final HashSet MINUS = new HashSet<>(Arrays.asList("A"));
    public static final HashSet DIFFERENCE = new HashSet<>(Arrays.asList("A", "C"));
    OperationOnSet operation;

    @Before
    public void init() {
        operation = new OperationOnSet();
    }

    @Test
    public void testUnite() {
        Assert.assertEquals(UNION, operation.unite(FIRST_SET, SECOND_SET));
    }

    @Test
    public void testIntersect() {
        Assert.assertEquals(INTERSECTION, operation.intersect(FIRST_SET, SECOND_SET));
    }

    @Test
    public void testCountDifference() {
        Assert.assertEquals(MINUS, operation.countDifference(FIRST_SET, SECOND_SET));
    }

    @Test
    public void testCountSymmetricalDifference() {
        Assert.assertEquals(DIFFERENCE, operation.countSymmetricalDifference(FIRST_SET, SECOND_SET));
    }

}