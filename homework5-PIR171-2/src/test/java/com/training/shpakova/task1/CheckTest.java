package com.training.shpakova.task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckTest {
    public static final String[] ARRAY = {"1", "2", "1.exe"};
    public static final String[] ARRAY_WITH_EMPTY_ELEMENTS = {"1", " "};
    public static final String[] ARRAY_ADDING_TO_FILE = {"1.exe", "1", "2.exe"};
    public static final String[] ARRAY_WRONG = {"1.exe", "1", " ", "2"};
    public static final boolean FAILURE = false;
    public static final boolean SUCCESS = true;
    boolean result;

    @Test
    public void testGetResultPositiveCase() {
        result = new Check().getResult(ARRAY);
        assertEquals(SUCCESS, result);
    }

    @Test
    public void testGetResultOnEmptyElements() {
        result = new Check().getResult(ARRAY_WITH_EMPTY_ELEMENTS);
        assertEquals(FAILURE, result);
    }

    @Test
    public void testGetResultOnAddingToFile() {
        result = new Check().getResult(ARRAY_ADDING_TO_FILE);
        assertEquals(FAILURE, result);
    }

    @Test
    public void testGetResultBothIncorrect() {
        result = new Check().getResult(ARRAY_WRONG);
        assertEquals(FAILURE, result);
    }

}