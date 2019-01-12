package py.com.prestosoftware.facepet.data.model;

public class Token {

    private boolean auth;
    private String token;

    public Token() {}

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
