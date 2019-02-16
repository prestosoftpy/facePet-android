package py.com.prestosoftware.facepet.domain.interactor;

import py.com.prestosoftware.facepet.data.model.Login;
import py.com.prestosoftware.facepet.data.model.Token;
import py.com.prestosoftware.facepet.data.model.Usuario;
import rx.Observable;

public interface UserInteractor {

    Observable<Usuario> loginUser(Login login);

    Observable<Token> registerUser(Usuario usuario);

    Observable<Usuario> UserData(int usuarioid);



}
