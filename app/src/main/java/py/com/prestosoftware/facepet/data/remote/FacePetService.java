package py.com.prestosoftware.facepet.data.remote;

import py.com.prestosoftware.facepet.data.model.Login;
import py.com.prestosoftware.facepet.data.model.Token;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

public interface FacePetService {

    static final String LOGIN_URL = "login";

    static final String User_url="usuarios";

    @POST(LOGIN_URL)
    Observable<Token> sigIn(@Body Login login);

    @GET(User_url)
    Observable<Usuario> getUserData(int id);


}
