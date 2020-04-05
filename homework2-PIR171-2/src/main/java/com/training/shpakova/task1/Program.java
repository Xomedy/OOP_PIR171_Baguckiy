package com.training.shpakova.task1;

public class Program {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        double m1 = Double.parseDouble(args[2]);
        double m2 = Double.parseDouble(args[3]);
        Counting action = new Counting();
        System.out.println(action.calculateG(a, p, m1, m2));
    }
}

