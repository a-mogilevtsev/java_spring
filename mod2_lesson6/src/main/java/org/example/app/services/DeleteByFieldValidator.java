package org.example.app.services;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by a.sosnina on 12/22/2022.
 */
public class DeleteByFieldValidator implements ConstraintValidator<DeleteByFieldConstraint, String> {

    @Override
    public void initialize(DeleteByFieldConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.startsWith("author:") || s.startsWith("title:");
    }
}
