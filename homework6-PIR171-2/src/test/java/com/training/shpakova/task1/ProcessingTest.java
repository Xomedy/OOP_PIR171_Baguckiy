package com.training.shpakova.task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessingTest {
    public static final Object[] WORD_LIST_1 = {"dogs", "enemy", "had", "he", "him", "his", "in", "kind",
            "of", "other", "own", "still", "the", "unlike", "was", "wild"};
    public static final Object[] COUNT_LIST_1 = {1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1};
    public static final Object[] WORD_LIST_2 = {"a", "at", "hillside", "lapping", "on", "once", "spring",
            "time", "upon", "was", "wolf"};
    public static final Object[] COUNT_LIST_2 = {4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    @Test
    public void testFormImmutableList1() {
        String input = "Unlike the other dogs, he still had the Wild in him. He was the enemy " +
                "of his own kind.";
        Processing p = new Processing(input);
        p.getImmutableWordDict().print();
        assertArrayEquals(WORD_LIST_1, p.getImmutableWordList());
        assertArrayEquals(COUNT_LIST_1, p.getImmutableWordListCount());
    }

    @Test
    public void testFormImmutableList2() {
        String input = "Once upon a time a Wolf was lapping at a spring on a hillside";
        Processing p = new Processing(input);
        p.getImmutableWordDict().print();
        assertArrayEquals(WORD_LIST_2, p.getImmutableWordList());
        assertArrayEquals(COUNT_LIST_2, p.getImmutableWordListCount());
    }

}