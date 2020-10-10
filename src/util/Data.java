package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author marcos-victor
 */
public class Data {

    public static String getHora() {

        Calendar data = Calendar.getInstance();
        int horas = data.get(Calendar.HOUR_OF_DAY);
        int min = data.get(Calendar.MINUTE);
        int seg = data.get(Calendar.SECOND);
        return horas + ":" + min + ":" + seg;

    }

    public static String getData() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = dateFormat.format(new Date());
        return dataFormatada;
    }

    public static String formataData(String data) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dataFormatada = dateFormat.format(data);
        return dataFormatada;
    }

}
