package com.training.shpakova.task2;

public class Factorial {
        int res = 1;
        int iterator = 1;

        public int calculateFactorialViaWhile(int number) {
            if (number == 1 || number == 0) {
                return res;
            }
            while (iterator <= number) {
                res *= iterator;
                iterator++;
            }
            return res;
        }

        public int calculateFactorialViaDoWhile(int number) {
            if (number == 1 || number == 0) {
                return res;
            }
            do {
                res *= iterator;
                iterator++;
            } while (iterator <= number);
            return res;
        }

        public int calculateFactorialViaFor(int number) {
            if (number == 1 || number == 0) {
                return res;
            }
            for (int i = 1; i <= number; i++) {
                res *= i;
            }
            return res;
        }
}
