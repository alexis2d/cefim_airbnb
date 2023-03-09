package alexis.airbnb.outils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Alexis Duquenet
 * Ceci est ma version de Date
 */
public class MaDate extends java.util.Date {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Date sans paramètres (date du jour)
     */
    public MaDate() {
        super();
    }

    /**
     * Date avec 1 string en paramètre (format "dd/MM/yyyy")
     * */
    public MaDate(String str) {
        /*
        * format de base de Date : "MM/dd/yyyy"
        * -> il faut intervertir jour et mois pour la bonne création de la Date en utilisant le format en paramètre
        * */
        super(str);
        int day = this.getDate();
        this.setDate(this.getMonth() + 1);
        this.setMonth(day - 1);
    }

    /**
     * Date avec 3 int en paramètres (jour, mois, année au format dd, MM, yyyy)
     * */
    public MaDate(int date, int month, int year) {
        super((year - 1900), (month - 1), date);
    }

    @Override
    public String toString() {
        return SIMPLE_DATE_FORMAT.format(this);
    }

    public static String staticToString(Date date) {
        return SIMPLE_DATE_FORMAT.format(date);
    }
}
