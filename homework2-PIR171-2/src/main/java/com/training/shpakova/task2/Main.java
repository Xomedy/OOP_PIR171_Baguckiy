package com.training.shpakova.task2;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String [] input;
        int algorithmId = -1, loopType = -1, parameter = -1;
        while (algorithmId==-1||loopType==-1||parameter== -1) {
            System.out.print("Your choice: ");
            input = scn.nextLine().split(" ");
            algorithmId = checkForRightInput(1, input[0]);
            loopType = checkForRightInput(2, input[1]);
            parameter = checkForRightInput(3, input[2]);
        }
        chooseAlgorithm(algorithmId, loopType, parameter);
    }

    private static int checkForRightInput(int inputNumber,String raw)  {
        int input = -1;
            try {
                input = Integer.parseInt(raw);
                if (inputNumber == 1) {
                    if (input != 1 && input != 2){
                        throw new NonexistentException("Wrong number of algorithm. Choose 1 or 2");
                    }
                }
                if (inputNumber == 2) {
                    if (input != 1 && input != 2 && input != 3){
                        throw new NonexistentException("Wrong number of loop. Choose loop from 1 to 3");
                    }
                }
                if (inputNumber == 3) {
                    if (input < 0) {
                        throw new NonexistentException("Negative parameter. Try again");
                    }
                }
            }
            catch (NumberFormatException e) {
                input = -1;
                System.out.println("This is not a number. Try again");
            }
            catch (NonexistentException e) {
                input = -1;
                System.out.println(e.getMessage());
            }
        return input;
    }
    private static void chooseAlgorithm(int algorithm, int loop, int parameter) {
        if (algorithm == 1) {
            Fibonacci fib = new Fibonacci(parameter);
            int [] result = calculateFibonacci(fib, loop, parameter);
            System.out.print("Fibonacci consequence: ");
            for (int v = 0; v < result.length; v++) {
                System.out.print(result[v]+ " ");
            }
        } else if (algorithm == 2) {
            Factorial fact = new Factorial();
            System.out.print("Factorial = "+calculateFactorial(fact,loop,parameter));
        }
    }

    public static int [] calculateFibonacci(Fibonacci fib, int loop, int parameter) {
        int [] result = {0};
        if (loop == 1) {
            result = fib.calculateFibonacciViaWhile(parameter);
        } else if (loop == 2) {
            result = fib.calculateFibonacciViaDoWhile(parameter);
        } else if (loop == 3) {
            result = fib.calculateFibonacciViaFor(parameter);
        }
        return result;
    }
    public static int calculateFactorial(Factorial fact,int loop, int parameter) {
        int result = 0;
        if (loop == 1) {
            result = fact.calculateFactorialViaWhile(parameter);
        } else if (loop == 2) {
            result = fact.calculateFactorialViaDoWhile(parameter);
        } else if (loop == 3) {
            result = fact.calculateFactorialViaFor(parameter);
        }
        return result;
    }
}
