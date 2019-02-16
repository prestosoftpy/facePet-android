package py.com.prestosoftware.facepet.data.model;

import com.google.gson.annotations.SerializedName;

public class Empresa {
    private int id;
    private String nombre;
    @SerializedName("imagen_url")
    private String imagen_url;

    private String direccion;



    public Empresa(){

    }

    public Empresa(int id, String nombre, String imagen_url, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.imagen_url = imagen_url;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return  nombre;//para que muestre en el sppiner de empresas en registerReservation
    }
}
