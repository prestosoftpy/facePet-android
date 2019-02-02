package py.com.prestosoftware.facepet.data.model;

public class Donaciones {

    private int id_donacion;
    private String nombreUsuario;
    private String celular;
    private String direccion;
    private String obs;

    public Donaciones() {
    }

    public int getId_donacion() {
        return id_donacion;
    }

    public void setId_donacion(int id_donacion) {
        this.id_donacion = id_donacion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
