package com.training.shpakova.task1;

import java.math.BigDecimal;

public class Execute {

    public static void main(String[] args) {
        Card card = new Card("1", new BigDecimal(500));
        for (int i = 1; i <= 4; i++) {
            Thread t1 = new Thread(new MoneyProducer(card));
            t1.setName("MoneyProducer" + i);
            Thread t2 = new Thread(new MoneyConsumer(card));
            t2.setName("MoneyConsumer" + i);
            t1.start();
            t2.start();
        }
    }

}
