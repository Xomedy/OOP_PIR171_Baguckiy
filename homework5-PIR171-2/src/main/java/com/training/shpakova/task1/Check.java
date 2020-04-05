package com.training.shpakova.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {

    public boolean getResult(String [] array) {
        return isNameEmpty(array) & checkForAddingToFile(array);
    }

    private boolean isNameEmpty(String [] array) {
        boolean result = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null || isNameEmpty(i, array)) {
                result = false;
                System.out.println("Incorrect input. Name mustn't be empty ");
            }
        }
        return result;
    }

    private boolean checkForAddingToFile(String [] array) {
        boolean result = true;
        for (int  i = 0; i < array.length - 1; i++) {
            if (isInputElementAFile(i, array)) {
                result = false;
                System.out.println("Incorrect input. You can't add anything to a file");
            }
        }
        return result;
    }

    private boolean isInputElementAFile(int index, String [] array) {
        final String pattern = ".*\\.[\\w|\\d]*";
        return doRegex(pattern, index, array);
    }

    private boolean isNameEmpty(int index, String [] array) {
        final String pattern = "[\\s]*";
        return doRegex(pattern, index, array);
    }

    private boolean doRegex(String pattern, int index, String [] array) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(array[index]);
        return m.matches();
    }

}
