package py.com.prestosoftware.facepet.data.model;

public class Login {

    private String correo;
    private String clave;

    public Login() {}

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
