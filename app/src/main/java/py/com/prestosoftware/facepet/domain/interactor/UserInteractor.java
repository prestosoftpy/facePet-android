package py.com.prestosoftware.facepet.domain.interactor;

import py.com.prestosoftware.facepet.data.model.Login;
import py.com.prestosoftware.facepet.data.model.Token;
import rx.Observable;

public interface UserInteractor {

    Observable<Token> loginUser(Login login);

}
