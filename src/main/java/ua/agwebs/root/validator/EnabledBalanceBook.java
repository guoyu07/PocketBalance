package ua.agwebs.root.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckBalanceBookEnable.class)
@Documented
public @interface EnabledBalanceBook {

    String message() default "Balance book doesn't exist or has been deleted.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
