package utilities;

import java.security.spec.RSAOtherPrimeInfo;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateHandler{


    public void parseDate(LocalDate date) throws Exception{
        LocalDate mDate = LocalDate.parse("dd/MM/yyyy");
    }

    public void getDays(LocalDate startDate, LocalDate endDate) throws Exception{
        long daysBetween = ChronoUnit.DAYS.between(startDate,endDate);
        System.out.println(daysBetween);
    }

}
