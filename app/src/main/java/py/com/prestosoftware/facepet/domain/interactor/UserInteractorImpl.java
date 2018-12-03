package py.com.prestosoftware.facepet.domain.interactor;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Login;
import py.com.prestosoftware.facepet.data.model.Token;
import py.com.prestosoftware.facepet.data.model.Usuario;
import py.com.prestosoftware.facepet.domain.repository.UserRepository;
import rx.Observable;

public class UserInteractorImpl implements UserInteractor {


    private UserRepository repository;

    @Inject
    public UserInteractorImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public Observable<Token> loginUser(Login login) {
        return repository.login(login);
    }

    @Override
    public Observable<Token> registerUser(Usuario usuario) {
        return repository.registerUser(usuario);
    }

}
