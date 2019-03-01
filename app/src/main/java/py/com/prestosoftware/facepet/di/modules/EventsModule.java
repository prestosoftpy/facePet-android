package py.com.prestosoftware.facepet.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import py.com.prestosoftware.facepet.data.remote.FacePetService;
import py.com.prestosoftware.facepet.data.repository.EventsDataRepository;
import py.com.prestosoftware.facepet.domain.interactor.EventsInteractor;
import py.com.prestosoftware.facepet.domain.interactor.EventsInteractorImpl;
import py.com.prestosoftware.facepet.domain.repository.EventsRepository;
import py.com.prestosoftware.facepet.ui.events.EventsPresenter;
import py.com.prestosoftware.facepet.ui.events.dummy.EventsContract;

@Module
public class EventsModule {


    @Provides
    @Singleton
    EventsContract.EventsPresenter providePresenter(EventsInteractor interactor){
        return new EventsPresenter(interactor);
    }

    @Provides
    @Singleton
    EventsInteractor provideInteractor(EventsRepository repository){
        return new EventsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    EventsRepository provideRepository(FacePetService service){
        return new EventsDataRepository(service);
    }
}
