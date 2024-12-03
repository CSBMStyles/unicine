package com.unicine.util.validacion.anotaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.Pattern;
import java.util.List;

public class MultiPatternValidator implements ConstraintValidator<MultiPattern, List<String>> {

    private Pattern[] patterns;

    @Override
    public void initialize(MultiPattern constraintAnnotation) {
        this.patterns = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Considera null como válido, usa @NotNull para validar null
        }

        for (String item : value) {
            for (Pattern pattern : patterns) {
                if (!item.matches(pattern.regexp())) {
                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate(pattern.message())
                           .addConstraintViolation();
                    return false;
                }
            }
        }
        return true;
    }
}