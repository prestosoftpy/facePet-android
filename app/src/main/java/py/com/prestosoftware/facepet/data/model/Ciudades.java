package py.com.prestosoftware.facepet.data.model;

import com.google.gson.annotations.SerializedName;

public class Ciudades {

    private int id;
    private String descripcion;
    @SerializedName("imagen_url")
    private String imagen_url;
    private String abreviatura;

    public Ciudades() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
}
