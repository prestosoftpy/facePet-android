package py.com.prestosoftware.facepet.domain.repository;

import py.com.prestosoftware.facepet.data.model.Login;
import py.com.prestosoftware.facepet.data.model.Token;
import rx.Observable;

public interface UserRepository {

    Observable<Token> login(Login login);

    Observable<usuarios> userData(Usuarios usuarios);

}
