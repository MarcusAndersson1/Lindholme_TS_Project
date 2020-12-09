package utilities;

import menus.Print;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateHandler {

    public static int getBusinessDaysBetween(String startDate, String endDate) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return currentDate;
    }
    public static String setDate(){
        int check;
        String day="";
        String year="";
        String month="";
        String date;
        do {
                    System.out.println("Day dd");
                    day = Input.fetchInputString("");

                    System.out.println("Month MM");
                    month = Input.fetchInputString("");
                    System.out.println("Year yyyy");
                    year = Input.fetchInputString("");
            date =  day + "/" + month + "/" + year;
        }while(!checkDate(date));
        return date;
    }

    public static boolean checkDate(String date){
        boolean b = false;
        LocalDate mDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       try {
            mDate = LocalDate.parse(date, formatter);
        if(mDate.isAfter(LocalDate.now())){
            b=true;
        }
       }catch(Exception e) {
           System.out.println(Print.ERROR_INPUT);
       }

        return b;
    }
}
