package py.com.prestosoftware.facepet.data.remote;

import py.com.prestosoftware.facepet.data.model.Login;
import py.com.prestosoftware.facepet.data.model.Token;
import py.com.prestosoftware.facepet.data.model.Usuario;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface FacePetService {

    static final String LOGIN_URL = "login";
    static final String REGISTER_URL = "usuarios";

    static final String User_url="usuarios/{id}";

    @POST(LOGIN_URL)
    Observable<Token> sigIn(@Body Login login);

    @GET(User_url)
    Observable<Usuario> getUserData(@Path("id") int usuarioid);


    @POST(REGISTER_URL)
    Observable<Token> registerUser(@Body Usuario usuario);


}
