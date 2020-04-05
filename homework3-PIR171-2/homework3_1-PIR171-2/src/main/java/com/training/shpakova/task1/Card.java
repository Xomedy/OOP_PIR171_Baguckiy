package com.training.shpakova.task1;

import java.math.BigDecimal;

import static java.math.RoundingMode.*;

class Card {
    private String cardholderName;
    private BigDecimal balanceSum;

    public Card(String ownerName, BigDecimal balance) {
        boolean correctOwnerName = checkForCorrectCardholderName(ownerName);
        boolean correctBalance = checkForNotNullAndForPositiveArgument(balance);
        if (correctOwnerName && correctBalance) {
            cardholderName = ownerName;
            balanceSum = balance;
        } else {
            cardholderName = "Alex";
            balanceSum = new BigDecimal(0);
        }
    }

    public Card(String ownerName) {
        if (checkForCorrectCardholderName(ownerName)) {
            cardholderName = ownerName;
            balanceSum = new BigDecimal(0);
        }
    }

    private boolean checkForCorrectCardholderName(String ownerName) {
        boolean correctCardholderName = (ownerName != "" && ownerName != null);
        if (! correctCardholderName) {
            System.out.println("Incorrect name");
        }
        return correctCardholderName;
    }

    public boolean checkForNotNullAndForPositiveArgument(BigDecimal amount) {
        return (amount != null) && amount.compareTo(new BigDecimal(0)) > 0;
    }

    public BigDecimal addTo(BigDecimal amount) {
        if (checkForNotNullAndForPositiveArgument(amount)) {
            balanceSum = balanceSum.add(amount).setScale(0, DOWN);
        }
        return balanceSum;
    }

    public BigDecimal withdraw(BigDecimal amount) {
        if (checkForWithdrawingAbility(amount)) {
            balanceSum = balanceSum.subtract(amount).setScale(0, DOWN);
        }
        return balanceSum;
    }

    public boolean checkForWithdrawingAbility(BigDecimal amount) {
        boolean correctInput = checkForNotNullAndForPositiveArgument(amount);
        return correctInput && balanceSum.compareTo(amount) > 0;
    }

    public BigDecimal displayCardBalance(BigDecimal exchangeRate) {
        if (checkForNotNullAndForPositiveArgument(exchangeRate)) {
            balanceSum = balanceSum.multiply(exchangeRate).setScale(0, DOWN);
        }
        return balanceSum;
    }

}
