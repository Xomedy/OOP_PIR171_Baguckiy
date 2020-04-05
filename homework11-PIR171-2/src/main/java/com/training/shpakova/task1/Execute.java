package com.training.shpakova.task1;

import java.io.*;
import java.util.Scanner;

public class Execute {
    public static void main(String[] args) {
        CompositeFolder mainFolder = new CompositeFolderBuilder().setName("C").build();
        try {
            FileInputStream fis = new FileInputStream("MyFile.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            mainFolder = (CompositeFolder) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            new File("MyFile.ser");
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (true) {
            System.out.println("1 - enter, \n2 - print,\n3 - stop,\n4 - save ");
            Scanner scn = new Scanner(System.in);
            String choice = scn.nextLine();
            if (choice.equals("1")) {
                System.out.println("....");
                String input = scn.nextLine();
                String[] array = input.split("/");
                mainFolder.perform(array);
            } else if (choice.equals("2")) {
                mainFolder.print(0);
            } else if (choice.equals("3")) {
                break;
            } else if (choice.equals("4")) {
                try {
                    FileOutputStream fs = new FileOutputStream("MyFile.ser");
                    ObjectOutputStream os = new ObjectOutputStream(fs);
                    os.writeObject(mainFolder);
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
