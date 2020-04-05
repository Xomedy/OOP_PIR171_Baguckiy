package com.training.shpakova.task1.ValidatorFactory;

import com.training.shpakova.task1.Validators.IntegerValidator;
import com.training.shpakova.task1.Validators.StringValidator;
import com.training.shpakova.task1.Validators.Validator;

public class ValidatorFactory {

    public Validator getValidator(ValidatorTypes type) {
        Validator result;
        switch (type) {
            case INTEGER:
                result = new IntegerValidator();
                break;
            case STRING:
                result = new StringValidator();
                break;
            default:
                throw new IllegalArgumentException("Wrong type:" + type);
        }
        return result;
    }

}
