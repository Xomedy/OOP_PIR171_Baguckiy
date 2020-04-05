package com.training.shpakova.task1.Validators;

import com.training.shpakova.task1.ValidationFailedException.ValidationFailedException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator implements Validator<String> {

    @Override
    public void validate(String input) throws ValidationFailedException {
        final String STRING_PATTERN = "^[A-ZА-Я].*";
        Pattern p = Pattern.compile(STRING_PATTERN);
        Matcher m = p.matcher(input);
        if (! m.matches()) {
            throw new ValidationFailedException("Wrong String format");
        }
    }

}
