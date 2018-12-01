package py.com.prestosoftware.facepet.data.remote;

import py.com.prestosoftware.facepet.data.model.Login;
import py.com.prestosoftware.facepet.data.model.Token;
import py.com.prestosoftware.facepet.data.model.Usuario;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface FacePetService {

    static final String LOGIN_URL = "login";
    static final String REGISTER_URL = "";

    @POST(LOGIN_URL)
    Observable<Token> sigIn(@Body Login login);

    @POST(REGISTER_URL)
    Observable<Token> registerUser(@Body Usuario usuario);

}
