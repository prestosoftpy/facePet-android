package py.com.prestosoftware.facepet.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import py.com.prestosoftware.facepet.helpers.Util;

public class FacePetPreference {

    // crea la preferencia en android en modo privado
    public static SharedPreferences preferences(final Context context) {
        return context.getSharedPreferences(Util.PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    // limpia el contenido de la preferencia
    public void clear(final Context context) {
        preferences(context).edit().clear().apply();
    }

    public static void setSesion(final Context context) {
        preferences(context).edit().putBoolean(Util.SESION_USER, true).apply();
    }

    public static Boolean getSesion(final Context context) {
        return preferences(context).getBoolean(Util.SESION_USER, false);
    }

    public static void setToken(final Context context, String token) {
        preferences(context).edit().putString(Util.TOKEN, token).apply();
    }

    public static String getToken(final Context context) {
        return preferences(context).getString(Util.TOKEN, "");
    }


}
