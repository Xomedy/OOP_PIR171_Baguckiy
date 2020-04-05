package com.training.shpakova.task1.Check;

public class Check {

    public void isEmpty(String input) {
        if (input == null || input.equals("")) {
            System.out.println("Incorrect input. Mustn't be empty ");
        }
    }

    public void isEmpty(Integer input) {
        if (input == null) {
            System.out.println("Incorrect input. Mustn't be empty ");
        }
    }

}
