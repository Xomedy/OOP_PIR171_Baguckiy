package com.training.shpakova.task2;

public class Fibonacci {
        private int firstNumber;
        private int secondNumber;
        private int [] fibonacciArray;
        private int tmp;
        public Fibonacci(int number){
            firstNumber = 0;
            secondNumber = 1;
            fibonacciArray = new int[number];
            tmp = 0;
        }


        public int [] calculateFibonacciViaWhile(int number) {
            int iterator = 0;
            while (iterator < number) {
                fibonacciArray[iterator] = firstNumber;
                tmp = firstNumber;
                firstNumber = secondNumber;
                secondNumber += tmp;
                iterator++;
            }
            return fibonacciArray;
        }

        public int [] calculateFibonacciViaDoWhile(int number) {
            int iterator = 0;
            do {
                fibonacciArray[iterator] = firstNumber;
                tmp = firstNumber;
                firstNumber = secondNumber;
                secondNumber += tmp;
                iterator++;
            } while (iterator < number);
            return fibonacciArray;
        }

    public int [] calculateFibonacciViaFor(int number) {
        for (int i = 0; i < number; i++) {
            fibonacciArray[i] = firstNumber;
            tmp = firstNumber;
            firstNumber = secondNumber;
            secondNumber += tmp;
        }
        return fibonacciArray;
    }

}
