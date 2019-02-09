package py.com.prestosoftware.facepet.data.model;

import java.util.Date;

public class Reservas {

    private int id;
    private Date fecha;
    private Empresa empresa_id;
    private int tipo_mascota;
    private int cantidad_mascotas;
    private int servicio_id;
    private String estado_reserva;

    public Reservas() {
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

    public Empresa getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(Empresa empresa_id) {
        this.empresa_id = empresa_id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public int getTipo_mascota() {
        return tipo_mascota;
    }

    public void setTipo_mascota(int tipo_mascota) {
        this.tipo_mascota = tipo_mascota;
    }

    public int getCantidad_mascotas() {
        return cantidad_mascotas;
    }

    public void setCantidad_mascotas(int cantidad_mascotas) {
        this.cantidad_mascotas = cantidad_mascotas;
    }

    public int getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(int servicio_id) {
        this.servicio_id = servicio_id;
    }

    public String getEstado_reserva() {
        return estado_reserva;
    }

    public void setEstado_reserva(String estado_reserva) {
        this.estado_reserva = estado_reserva;
    }
}
