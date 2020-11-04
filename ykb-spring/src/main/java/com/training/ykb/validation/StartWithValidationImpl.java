package com.training.ykb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithValidationImpl implements ConstraintValidator<StartWith, String> {

    private StartWith constraintAnnotation;

    @Override
    public void initialize(final StartWith constraintAnnotationParam) {
        this.constraintAnnotation = constraintAnnotationParam;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        return valueParam.startsWith(this.constraintAnnotation.value());
    }

}
