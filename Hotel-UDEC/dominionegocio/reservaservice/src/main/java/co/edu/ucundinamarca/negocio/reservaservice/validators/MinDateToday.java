package co.edu.ucundinamarca.negocio.reservaservice.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target( { FIELD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MinDateTodayValidator.class)
public @interface MinDateToday {
    String message() default "La fecha minima debe ser mayor o igual a hoy";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
