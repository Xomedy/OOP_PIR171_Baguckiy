package com.training.shpakova.task1;

import org.junit.*;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CardTest {
    public static final String NAME_OWNER = "Cardholder Name";
    public static final String EMPTY_NAME_OWNER = "";
    public static final BigDecimal BALANCE = new BigDecimal(1000);
    public static final BigDecimal EMPTY_BALANCE = null;
    public static final BigDecimal NEGATIVE_BALANCE = new BigDecimal(-200);

    @Test
    public void testFirstConstructorForNullCardholderName() {
        Card card = new Card(EMPTY_NAME_OWNER, BALANCE);
    }

    @Test
    public void testFirstConstructorForNullCardBalance() {
        Card card = new Card(NAME_OWNER, EMPTY_BALANCE);
    }

    @Test
    public void testFirstConstructorForNegativeCardBalance() {
        Card card = new Card(NAME_OWNER, NEGATIVE_BALANCE);
    }

    @Test
    public void testFirstConstructorForBothIncorrectArguments() {
        Card card = new Card(EMPTY_NAME_OWNER, NEGATIVE_BALANCE);
    }

    @Test
    public void testSecondConstructorForNullCardholderName() {
        Card card = new Card(EMPTY_NAME_OWNER);
    }

    @Test
    public void testAddToForNullAdditive() {
        Card card = new Card(NAME_OWNER, BALANCE);
        assertEquals(BALANCE, card.addTo(null));
    }

    @Test
    public void testAddToForNegativeAdditive() {
        Card card = new Card(NAME_OWNER, BALANCE);
        assertEquals(BALANCE, card.addTo(NEGATIVE_BALANCE));
    }

    @Test
    public void testWithdrawForNullArgument() {
        Card card = new Card(NAME_OWNER, BALANCE);
        assertEquals(BALANCE, card.withdraw(EMPTY_BALANCE));
    }

    @Test
    public void testWithdrawForNegativeArgument() {
        Card card = new Card(NAME_OWNER, BALANCE);
        assertEquals(BALANCE, card.withdraw(NEGATIVE_BALANCE));
    }

    @Test
    public void testWithdrawForTooBigWithdrawing() {
        Card card = new Card(NAME_OWNER, BALANCE);
        assertEquals(BALANCE, card.withdraw(new BigDecimal(2000)));
    }

    @Test
    public void testDisplayCardBalanceForNullArgument() {
        Card card = new Card(NAME_OWNER, BALANCE);
        assertEquals(BALANCE, card.displayCardBalance(EMPTY_BALANCE));
    }

    @Test
    public void testDisplayCardBalanceForNegativeArgument() {
        Card card = new Card(NAME_OWNER, BALANCE);
        assertEquals(BALANCE, card.displayCardBalance(NEGATIVE_BALANCE));
    }

}