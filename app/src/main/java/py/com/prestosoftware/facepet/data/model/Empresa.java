package py.com.prestosoftware.facepet.data.model;

import com.google.gson.annotations.SerializedName;

public class Empresa {

    private int id;
    private String nombre;

    @SerializedName("imagen_url")
    private String imagenUrl;

    public Empresa() {}

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

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

}
