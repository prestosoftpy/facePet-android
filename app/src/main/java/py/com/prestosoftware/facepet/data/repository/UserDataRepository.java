package py.com.prestosoftware.facepet.data.repository;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Login;
import py.com.prestosoftware.facepet.data.model.Token;
import py.com.prestosoftware.facepet.data.remote.FacePetService;
import py.com.prestosoftware.facepet.domain.repository.UserRepository;
import rx.Observable;

public class UserDataRepository implements UserRepository {

    private FacePetService service;

    @Inject
    public UserDataRepository(FacePetService service) {
        this.service = service;
    }

    @Override
    public Observable<Token> login(Login login) {
        return service.sigIn(login);
    }

}
