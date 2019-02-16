package py.com.prestosoftware.facepet.data.model;

public class Reservas {

    private String fecha;
    private int usuarioId;
    private int empresaId;
    private String imagenUrl;
    private int tipoMascota;
    private int cantidadMascota;
    private int servicioId;
    private String estado;

    public Reservas() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public int getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(int tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public int getCantidadMascota() {
        return cantidadMascota;
    }

    public void setCantidadMascota(int cantidadMascota) {
        this.cantidadMascota = cantidadMascota;
    }

    public int getServicioId() {
        return servicioId;
    }

    public void setServicioId(int servicioId) {
        this.servicioId = servicioId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reservas{" +
                "fecha='" + fecha + '\'' +
                ", empresaId=" + empresaId +
                ", imagenUrl='" + imagenUrl + '\'' +
                ", tipoMascota=" + tipoMascota +
                ", cantidadMascota=" + cantidadMascota +
                ", servicioId=" + servicioId +
                ", estado='" + estado + '\'' +
                '}';
    }
}
