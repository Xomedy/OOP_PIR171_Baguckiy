package com.training.shpakova.task1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FixedSizeListTest {
    public static final String FIRST_ELEMENT = "first";
    public static final String SECOND_ELEMENT = "second";
    public static final String THIRD_ELEMENT = "third";
    public static final int INITIAL_SIZE = 0;
    public static final boolean POSITIVE_RESULT = true;
    public static final boolean NEGATIVE_RESULT = false;
    FixedSizeList fixedSizeList;

    @Before
    public void init() {
        fixedSizeList = new FixedSizeList();
    }

    @Test
    public void testAddPositiveCase() {
        Assert.assertEquals(POSITIVE_RESULT, fixedSizeList.add(FIRST_ELEMENT));
    }

    @Test
    public void testAddNegativeCase() {
        for (int i = 0; i < 4; i++) {
            fixedSizeList.add(FIRST_ELEMENT);
        }
        Assert.assertEquals(NEGATIVE_RESULT, fixedSizeList.add(SECOND_ELEMENT));
    }

    @Test
    public void testContains() {
        Assert.assertEquals(NEGATIVE_RESULT, fixedSizeList.contains(FIRST_ELEMENT));
    }

    @Test
    public void testRemovePositiveCase() {
        fixedSizeList.add(FIRST_ELEMENT);
        fixedSizeList.add(SECOND_ELEMENT);
        Assert.assertEquals(POSITIVE_RESULT, fixedSizeList.remove(FIRST_ELEMENT));
    }

    @Test
    public void testRemoveNegativeCase() {
        fixedSizeList.add(FIRST_ELEMENT);
        fixedSizeList.add(SECOND_ELEMENT);
        Assert.assertEquals(NEGATIVE_RESULT, fixedSizeList.remove(THIRD_ELEMENT));
    }

    @Test
    public void testIndexOf() {
        fixedSizeList.add(FIRST_ELEMENT);
        fixedSizeList.add(SECOND_ELEMENT);
        Assert.assertEquals(0, fixedSizeList.indexOf(FIRST_ELEMENT));
    }

    @Test
    public void testAddAll() {
        Assert.assertEquals(POSITIVE_RESULT, fixedSizeList.addAll(Arrays.asList(new String[]{FIRST_ELEMENT, SECOND_ELEMENT})));
    }

    @Test
    public void testClear() {
        fixedSizeList.add(FIRST_ELEMENT);
        fixedSizeList.clear();
        Assert.assertEquals(INITIAL_SIZE, fixedSizeList.size());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertEquals(POSITIVE_RESULT, fixedSizeList.isEmpty());
    }

}