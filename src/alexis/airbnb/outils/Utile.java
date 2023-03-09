package alexis.airbnb.outils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utile {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private Utile() {
    }

    /**
    * Date avec 1 string (format "dd/mm/yyyy")
    * */
    public static Date getDate(String str) {
        String[] splittedStr = str.split("/");
        int day = Integer.parseInt(splittedStr[0]);
        int month = Integer.parseInt(splittedStr[1]);
        int year = Integer.parseInt(splittedStr[2]);
        return getDate(day,month,year);
    }

    /**
    * Date avec 3 int (jour, mois, année)
    * */
    public static Date getDate(int day, int month, int year) {
        Date date = new Date();
        date.setDate(day);
        date.setMonth(month - 1);
        date.setYear(year - 1900);
        return date;
    }

    public static String getFormattedDate(Date date) {
        // méthode 1
        /*String day = formatDayOrMonth(date.getDate());
        String month = formatDayOrMonth(date.getMonth() + 1);
        return day + "/" + month + "/" + (date.getYear() + 1900);*/

        // méthode 2
        return SIMPLE_DATE_FORMAT.format(date);
    }

    public static String formatDayOrMonth(int date) {
        String day;
        if (date >= 10) {
            day = String.valueOf(date);
        } else {
            day = "0" + date;
        }
        return day;
    }

}
