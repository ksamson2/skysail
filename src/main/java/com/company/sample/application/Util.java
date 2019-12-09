package com.company.sample.application;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Util {
    /**
     * generate a random date in this year
     * @return
     */
    public static Date getRandomDate(){

        GregorianCalendar gc = new GregorianCalendar();

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return gc.getTime();
    }

    /**
     * get a random number between start and end
     * @param start
     * @param end
     * @return
     */
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    /**
     * Judge two dates are in the same day
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if(date1 == null && date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        //logic to compare the dates and return boolean.
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
    }
}
