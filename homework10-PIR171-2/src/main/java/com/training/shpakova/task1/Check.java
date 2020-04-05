package com.training.shpakova.task1;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Check {
    public static final BigDecimal highBorder = new BigDecimal(1000);

    public static boolean isCardholderNameCorrect(String ownerName) {
        boolean correctCardholderName = (ownerName != "" && ownerName != null);
        if (! correctCardholderName) {
            System.out.println("Incorrect name");
        }
        return correctCardholderName;
    }

    public static boolean checkAmount(BigDecimal amount) {
        boolean correctAmount = (amount != null) && amount.compareTo(new BigDecimal(0)) > 0;
        if (! correctAmount) {
            System.out.println("Incorrect amount");
        }
        return correctAmount;
    }

    public static boolean checkForAddingAbility(BigDecimal balanceSum, BigDecimal amount) {
        boolean result = false;
        if (checkAmount(amount)) {
            BigDecimal transitionalAmount = balanceSum.add(amount).setScale(0, RoundingMode.DOWN);
            if (transitionalAmount.compareTo(highBorder) > 0) {
                System.out.printf("%s.........................   Balance sum exceeded 1000$ \n", Thread.currentThread().getName());
            } else {
                result = true;
            }
        }
        return result;
    }

    public static boolean checkForWithdrawingAbility(BigDecimal balanceSum, BigDecimal amount) {
        if (balanceSum.compareTo(amount) <= 0) {
            System.out.printf("%s.........................   Balance sum 0$ \n", Thread.currentThread().getName());
        }
        return checkAmount(amount) && balanceSum.compareTo(amount) >= 0;
    }

}

