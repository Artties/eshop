package com.Jenna.eshop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Jenna C He
 * @date 2023/1/6 13:58
 */
public class AgeValidator implements ConstraintValidator<Age, Integer> {

    private Integer max;
    private Integer min;
    
    public void initialize(Age age) {
        this.max = age.max();
        this.min = age.min();
    }
    
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value < max && value > min;
    }
    
}