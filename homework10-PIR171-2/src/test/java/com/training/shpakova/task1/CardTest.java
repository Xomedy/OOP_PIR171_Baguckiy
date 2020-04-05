package com.training.shpakova.task1;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CardTest {
    public static final String NAME_OWNER = "Cardholder Name";
    public static final BigDecimal BALANCE = new BigDecimal(900);
    public static final BigDecimal NEGATIVE_ADDITION = new BigDecimal(-200);
    public static final BigDecimal LITTLE_AMOUNT = new BigDecimal(100);
    public static final BigDecimal TOO_BIG_WITHDRAWAL = new BigDecimal(901);
    public static final boolean SUCCESS = true;
    public static final boolean FAILURE = false;
    private Card card;

    @Before
    public void init() {
        card = new Card(NAME_OWNER, BALANCE);
    }

    @Test
    public void testAddToForPositiveCase() {
        assertEquals(SUCCESS, card.addTo(LITTLE_AMOUNT));
    }

    @Test
    public void testAddToForNullAdditive() {
        assertEquals(FAILURE, card.addTo(null));
    }

    @Test
    public void testAddToForNegativeAdditive() {
        assertEquals(FAILURE, card.addTo(NEGATIVE_ADDITION));
    }

    @Test
    public void testWithdrawToForPositiveCase() {
        assertEquals(SUCCESS, card.withdraw(LITTLE_AMOUNT));
    }

    @Test
    public void testWithdrawForTooBigWithdrawing() {
        assertEquals(FAILURE, card.withdraw(TOO_BIG_WITHDRAWAL));
    }

    @Test
    public void testWithdrawForNullAdditive() {
        assertEquals(FAILURE, card.addTo(null));
    }

    @Test
    public void testWithdrawForNegativeAdditive() {
        assertEquals(FAILURE, card.addTo(NEGATIVE_ADDITION));
    }

}