package py.com.prestosoftware.facepet.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import py.com.prestosoftware.facepet.data.remote.FacePetService;
import py.com.prestosoftware.facepet.data.repository.UserDataRepository;
import py.com.prestosoftware.facepet.domain.interactor.UserInteractor;
import py.com.prestosoftware.facepet.domain.interactor.UserInteractorImpl;
import py.com.prestosoftware.facepet.domain.repository.UserRepository;
import py.com.prestosoftware.facepet.ui.users.login.LoginContract;
import py.com.prestosoftware.facepet.ui.users.login.LoginPresenter;
import py.com.prestosoftware.facepet.ui.users.profile.ProfileContract;
import py.com.prestosoftware.facepet.ui.users.profile.ProfilePresenter;
import py.com.prestosoftware.facepet.ui.users.register.RegisterContract;
import py.com.prestosoftware.facepet.ui.users.register.RegisterPresenter;


@Module
public class UserModule {

    @Provides
    @Singleton
    LoginContract.LoginPresenter providePresenter(UserInteractor interactor){
        return new LoginPresenter(interactor);
    }

    @Provides
    @Singleton
    RegisterContract.RegisterPresenter provideRegisterPresenter(UserInteractor interactor){
        return new RegisterPresenter(interactor);
    }

    @Provides
    @Singleton
    UserInteractor provideInteractor(UserRepository repository) {
        return new UserInteractorImpl(repository);
    }

    @Provides
    @Singleton
    UserRepository provideRepository(FacePetService service) {
        return new UserDataRepository(service);
    }

    @Provides
    @Singleton
    ProfileContract.ProfilePresenter provideProfilePresenter(UserInteractor interactor) {
        return new ProfilePresenter(interactor);
    }

}
