package edu.wctc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final String PATTERN = "MM/dd/yyyy";

    public static Date parseDate(String str) {
        try {
            return new SimpleDateFormat(PATTERN).parse(str);
        } catch (ParseException e) {
            // If something fails, return today's date
            e.printStackTrace();
            return new Date();
        }
    }

    public static String formatDate(Date date) {
        if (date != null) {
            return new SimpleDateFormat(PATTERN).format(date);
        }
        // return today's date
        return new SimpleDateFormat(PATTERN).format(new Date());
    }
}
