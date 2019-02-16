package py.com.prestosoftware.facepet.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import py.com.prestosoftware.facepet.helpers.Util;

public class FacePetPreference {

    //Crea la Preferencia en android en modo privado
    public static SharedPreferences preferences(final Context context){
        return context.getSharedPreferences(Util.PREF_FILE_NAME, Context.MODE_PRIVATE);
    }


    //Limpia el contenido de la Preferencia
    public void clear(final Context context){
        preferences(context).edit().clear().apply();
    }

    public static void setSesion(final Context context){
        preferences(context).edit().putBoolean(Util.SESSION_USER, true).apply();
    }

    public static void setToken(final Context context, String token){
        preferences(context).edit().putString(Util.TOKEN,token).apply();
    }

    public static Boolean getSesion(final Context context){
        return preferences(context).getBoolean(Util.SESSION_USER,false);
    }

    public static String getToken(final Context context){
        return preferences(context).getString(Util.TOKEN,"");
    }

    public static int getUsuarioID(final Context context){
        return preferences(context).getInt(Util.USUARIO_ID,0);
    }

    public static void setUsuarioID(final Context context, int usuarioid){
        preferences(context).edit().putInt(Util.USUARIO_ID, usuarioid).apply();
    }
}
