package py.com.prestosoftware.facepet.domain.repository;

import py.com.prestosoftware.facepet.data.model.Login;
import py.com.prestosoftware.facepet.data.model.Token;
import py.com.prestosoftware.facepet.data.model.Usuario;
import rx.Observable;

public interface UserRepository {

    Observable<Token> login(Login login);

    Observable<Token> registerUser(Usuario usuario);

}
