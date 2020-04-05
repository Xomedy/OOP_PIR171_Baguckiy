package com.training.shpakova.task1;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        CompositeFolder mainFolder = new CompositeFolderBuilder().setName("C").build();
        while (true) {
            Scanner scn = new Scanner(System.in);
            String input = scn.nextLine();
            if (input.equals("stop")) {
                break;
            } else if (input.equals("print")) {
                mainFolder.print(0);
            } else {
                String[] array = input.split("/");
                mainFolder.perform(array);
            }
        }
    }
}
