package py.com.prestosoftware.facepet.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static final String PREF_FILE_NAME = "PREFERENCES_FACEPETS";
    public static final String SESSION_USER = "SESSION_USER";
    public static final String TOKEN = "TOKEN";
    public static final String LATITUD = "LATITUD";
    public static final String LONGITUD = "LONGITUD";
    public static String formatoFechaDDMMAAAA(Date fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fecha);
    }
}

