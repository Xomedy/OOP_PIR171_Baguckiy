package com.training.shpakova.task1.Validators;

import com.training.shpakova.task1.ValidationFailedException.ValidationFailedException;

public class IntegerValidator implements Validator<Integer> {

    @Override
    public void validate(Integer number) throws ValidationFailedException {
        if (number < 1 || number > 10) {
            throw new ValidationFailedException("Wrong Integer format");
        }
    }

}
