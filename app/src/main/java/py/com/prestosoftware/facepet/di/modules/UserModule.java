package py.com.prestosoftware.facepet.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import py.com.prestosoftware.facepet.data.remote.FacePetService;
import py.com.prestosoftware.facepet.data.repository.UserDataRepository;
import py.com.prestosoftware.facepet.domain.interactor.UserInteractor;
import py.com.prestosoftware.facepet.domain.interactor.UserInteractorImpl;
import py.com.prestosoftware.facepet.domain.repository.UserRepository;

@Module
public class UserModule {

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

}
