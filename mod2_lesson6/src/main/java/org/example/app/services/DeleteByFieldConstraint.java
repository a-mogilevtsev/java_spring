package org.example.app.services;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by a.sosnina on 12/22/2022.
 */
@Documented
@Constraint(validatedBy = DeleteByFieldValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DeleteByFieldConstraint {
    String message() default "Wrong input";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
