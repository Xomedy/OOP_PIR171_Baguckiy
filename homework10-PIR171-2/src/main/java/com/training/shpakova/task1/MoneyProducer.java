package com.training.shpakova.task1;

import java.math.BigDecimal;

public class MoneyProducer implements Runnable {
    private int lowAddBorder = 50;
    private int highAddBorder = 100;
    private Card card;

    public MoneyProducer(Card card) {
        this.card = card;
    }

    @Override
    public synchronized void run() {
        while (card.getIsChecked()) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int rndAddition = (int) (Math.random() * (highAddBorder - lowAddBorder) + lowAddBorder);
            card.addTo(BigDecimal.valueOf(rndAddition));
        }
    }

}

