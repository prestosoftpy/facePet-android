package py.com.prestosoftware.facepet.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import py.com.prestosoftware.facepet.data.remote.FacePetService;
import py.com.prestosoftware.facepet.data.repository.ReservationsDataRepository;
import py.com.prestosoftware.facepet.domain.interactor.ReservationsInteractor;
import py.com.prestosoftware.facepet.domain.interactor.ReservationsInteractorlmpl;
import py.com.prestosoftware.facepet.domain.repository.ReservationsRepository;
import py.com.prestosoftware.facepet.ui.reservations.Register.RegisterReservationsContract;
import py.com.prestosoftware.facepet.ui.reservations.Register.RegisterReservationsPresenter;

@Module
public class ReservationsModule {


    @Provides
    @Singleton
    RegisterReservationsContract.RerservationsPresenter providePresenter(ReservationsInteractor interactor){//pantalla
        return new RegisterReservationsPresenter(interactor);
    }
    @Provides
    @Singleton
    ReservationsInteractor provideInteractor(ReservationsRepository repository){//Intermediario entre pantalla y datos
        return new ReservationsInteractorlmpl(repository);
    }
    @Provides
    @Singleton
    ReservationsRepository provideRepository(FacePetService service){//Datos
        return new ReservationsDataRepository(service);
    }
}
