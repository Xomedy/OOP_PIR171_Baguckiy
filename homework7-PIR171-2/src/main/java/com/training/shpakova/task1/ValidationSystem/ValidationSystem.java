package com.training.shpakova.task1.ValidationSystem;

import com.training.shpakova.task1.Check.Check;
import com.training.shpakova.task1.ValidationFailedException.ValidationFailedException;
import com.training.shpakova.task1.ValidatorFactory.ValidatorFactory;
import com.training.shpakova.task1.ValidatorFactory.ValidatorTypes;
import com.training.shpakova.task1.Validators.Validator;

public class ValidationSystem {
    private static Validator validator;
    private static final ValidatorFactory factory = new ValidatorFactory();
    private static final Check check = new Check();

    public static void validate(Integer number) throws ValidationFailedException {
        check.isEmpty(number);
        validator = factory.getValidator(ValidatorTypes.INTEGER);
        validator.validate(number);
    }

    public static void validate(String input) throws ValidationFailedException {
        check.isEmpty(input);
        validator = factory.getValidator(ValidatorTypes.STRING);
        validator.validate(input);
    }

}
