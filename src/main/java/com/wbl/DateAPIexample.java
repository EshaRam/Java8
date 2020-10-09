package com.wbl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateAPIexample {

    public static void main(String[] args) {
        // dd/MM/yy is case sensitive.If 3 ‘M’, then the month is interpreted as text (Mon-Dec), else number (01-12).
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        try {
            Date date = dateFormat.parse("21/03/82");
            System.out.println(date);
            System.out.println(dateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Duration hour = Duration.ofHours(1);
        System.out.println("seconds ="+hour.getSeconds());
        Duration onehour = Duration.of(1, ChronoUnit.HOURS);
        System.out.println(onehour.getSeconds());

        LocalDateTime olddate = LocalDateTime.of(2020,03,5,10,30);
        LocalDateTime currentdate = LocalDateTime.now();
        Duration duration = Duration.between(olddate,currentdate);
        System.out.println("Time diff in seconds is = "+duration.getSeconds());

        Period days = Period.of(2,10,15);
        System.out.println(days.getMonths());

        LocalDate old = LocalDate.of(1982, Month.MARCH,21);
        LocalDate present = LocalDate.of(2020,Month.SEPTEMBER,11);
        Period diff = Period.between(old,present);
        System.out.println(diff.getYears()+" Years");
        System.out.println(diff.getMonths()+" Months");
        System.out.println(diff.getDays()+" days");

    }
}
