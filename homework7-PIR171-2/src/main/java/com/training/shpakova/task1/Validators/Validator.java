package com.training.shpakova.task1.Validators;

import com.training.shpakova.task1.ValidationFailedException.ValidationFailedException;

public interface Validator<T> {
    void validate(T s) throws ValidationFailedException;
}
