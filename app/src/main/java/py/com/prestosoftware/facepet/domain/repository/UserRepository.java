package py.com.prestosoftware.facepet.domain.repository;

import py.com.prestosoftware.facepet.data.model.Login;
import py.com.prestosoftware.facepet.data.model.Token;
import py.com.prestosoftware.facepet.data.model.Usuario;
import rx.Observable;

public interface UserRepository {

    Observable<Usuario> login(Login login);


    Observable<Usuario> userData(int id);

    Observable<Token> registerUser(Usuario usuario);


}
