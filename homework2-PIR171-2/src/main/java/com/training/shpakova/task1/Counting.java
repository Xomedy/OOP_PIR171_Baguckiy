package com.training.shpakova.task1;

class Counting{
    public double calculateG(Integer a, Integer p, double m1, double m2)
    {
        double G = 4*Math.PI * (Math.pow(a,3)/Math.pow(p,2)*(m1+m2));
        return G;
    }
}