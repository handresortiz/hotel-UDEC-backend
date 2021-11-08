package co.edu.ucundinamarca.negocio.reservaservice.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MinDateTodayValidator implements ConstraintValidator< MinDateToday, Date > {

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext cxt) {
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr = dateFormat.format( today );
        try{
            today = dateFormat.parse(todayStr);
        }catch(ParseException ex){
            ex.printStackTrace();
        }

        return date != null && (date.equals( today ) || date.after( today ));
    }
}
