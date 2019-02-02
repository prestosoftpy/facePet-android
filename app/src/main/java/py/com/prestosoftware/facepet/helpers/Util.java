package py.com.prestosoftware.facepet.helpers;

public class Util {

    public static final String PREF_FILE_NAME = "PREFERENCES_FACEPETS";
    public static final String SESSION_USER = "SESSION_USER";
    public static final String TOKEN = "TOKEN";

    public static String getMascotas(String id) {
        String nombre = "";
        switch (id) {
            case "1":
                nombre = "Perro";
                break;
            case "2":
                nombre = "Gato";
                break;
            case "3":
                nombre = "Ave";
                break;
        }
        return nombre;
    }


}
