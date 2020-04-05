package com.training.shpakova.task1;

import java.math.BigDecimal;

import static java.math.RoundingMode.*;

public class Card {
    private String cardholderName;
    private volatile BigDecimal balanceSum;
    private volatile boolean isChecked;

    public Card(String ownerName, BigDecimal balance) {
        boolean correctOwnerName = Check.isCardholderNameCorrect(ownerName);
        boolean correctBalance = Check.checkAmount(balance);
        if (correctOwnerName && correctBalance) {
            cardholderName = ownerName;
            balanceSum = balance;
        } else {
            cardholderName = "Alex";
            balanceSum = new BigDecimal(0);
        }
        isChecked = true;
    }

    public Card(String ownerName) {
        if (Check.isCardholderNameCorrect(ownerName)) {
            cardholderName = ownerName;
            balanceSum = new BigDecimal(0);
        } else {
            cardholderName = "Alex";
            balanceSum = new BigDecimal(0);
        }
        isChecked = true;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public BigDecimal getBalanceSum() {
        return balanceSum;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public synchronized boolean addTo(BigDecimal amount) {
        if (isChecked) {
            boolean success = false;
            if (Check.checkForAddingAbility(getBalanceSum(), amount)) {
                balanceSum = balanceSum.add(amount).setScale(0, DOWN);
                System.out.printf("%s .   Added %.1f . Now balance = %s \n", Thread.currentThread().getName(), amount, balanceSum);
                success = true;
            }
            isChecked = success;
        }
        return isChecked;
    }

    public synchronized boolean withdraw(BigDecimal amount) {
        if (isChecked) {
            boolean success = false;
            if (Check.checkForWithdrawingAbility(getBalanceSum(), amount)) {
                balanceSum = balanceSum.subtract(amount).setScale(0, DOWN);
                System.out.printf("%s .   Withdrawn %.1f. Now balance = %s \n", Thread.currentThread().getName(), amount, balanceSum);
                success = true;
            }
            isChecked = success;
        }
        return isChecked;
    }

}


