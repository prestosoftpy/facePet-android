package py.com.prestosoftware.facepet.helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import py.com.prestosoftware.facepet.data.model.Empresa;

public class Util {

    public static final String PREF_FILE_NAME = "PREFERENCES_FACEPETS";
    public static final String SESSION_USER = "SESSION_USER";
    public static final String TOKEN = "TOKEN";
    public static final String USUARIO_ID= "USUARIO_ID";

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

    public static String formatoFechaDDMMAAAA(Date fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy") ;
        return formato.format(fecha);
    }

    public static String formatoFechaAAAAMMDD(Date fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd") ;
        return formato.format(fecha);
    }

    public static List<Empresa> getEmpresas() {//Lista de empresas para el spinner
        List<Empresa> empresasList = new ArrayList<>();
        empresasList.add(new Empresa(1, "Veterinaria1","jsdkj","Av Peru"));
        empresasList.add(new Empresa(1, "Veterinaria2","jsdkj","Av Peru"));
        empresasList.add(new Empresa(1, "Veterinaria3","jsdkj","Av Peru"));
        empresasList.add(new Empresa(1, "Veterinaria4","jsdkj","Av Peru"));

        return empresasList;
    }
}
