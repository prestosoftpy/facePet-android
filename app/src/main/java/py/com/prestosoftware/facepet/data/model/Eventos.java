package py.com.prestosoftware.facepet.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Eventos {


    private int id;
    private Date fecha;
    private int ciudadId;
    @SerializedName("Usuario")
    private Usuario usuario;
    private int usuarioId;
    private String nombre;
    private String descripcion;
    private Float latitud;
    private Float longitud;
    private String imagenUrl;
    private String situacion;
    private int activo;

    /*
*       "id": 1,
        "fecha": "2019-01-26T14:32:01.000Z",
        "ciudadId": 1,
        "usuarioId": 1,
        "nombre": "Se dona Perro",
        "descripcion": "Perrito buenito un poco pulgoso",
        "latitud": "-25.504897",
        "longitud": "-54.680811",
        "imagenUrl": "SeDonaPerro-Img",
        "situacion": 0,
        "activo": 1
* */

    public Eventos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(int ciudadId) {
        this.ciudadId = ciudadId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Eventos{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", ciudadId=" + ciudadId +
                ", usuarioId=" + usuario.getNombre() +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", imagenUrl='" + imagenUrl + '\'' +
                ", situacion='" + situacion + '\'' +
                ", activo=" + activo +
                '}';
    }
}


