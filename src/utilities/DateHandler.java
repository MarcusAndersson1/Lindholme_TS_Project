package utilities;

import java.security.spec.RSAOtherPrimeInfo;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateHandler {

    public int getBusinessDaysBetween(String startDate, String endDate) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-H:mm");
        LocalDate mStartDate = LocalDate.parse(startDate, formatter);
        LocalDate mEndDate = LocalDate.parse(endDate, formatter);
        List<LocalDate> allDays = new ArrayList<>();
        List<LocalDate> businessDays = new ArrayList<>();
        //long daysBetween = ChronoUnit.DAYS.between(mStartDate, mEndDate); if we want regular days
        while (!mStartDate.isAfter(mEndDate)) {
            allDays.add(mStartDate);
            mStartDate = mStartDate.plusDays(1);
        }
        for (LocalDate day : allDays) {
            if (day.getDayOfWeek() != DayOfWeek.SUNDAY && day.getDayOfWeek() != DayOfWeek.SATURDAY) {
                businessDays.add(day);
            }
        }
        return businessDays.size();
    }
    public static String getCurrentDate(){
        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - H:mm"));
        return currentDate;
    }
    public static String setDate(){
        System.out.println("Day DD");
        int day = Input.fetchInputInt("");
        System.out.println("Month MM");
        int month = Input.fetchInputInt("");
        System.out.println("Year yyyy");
        int year = Input.fetchInputInt("");
        return day +"/" + month + "/"+year;
    }
}
