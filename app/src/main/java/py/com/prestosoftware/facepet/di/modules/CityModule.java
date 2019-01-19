package py.com.prestosoftware.facepet.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import py.com.prestosoftware.facepet.data.remote.FacePetService;
import py.com.prestosoftware.facepet.data.repository.CityDataRepository;
import py.com.prestosoftware.facepet.domain.interactor.CityInteractor;
import py.com.prestosoftware.facepet.domain.interactor.CityInteractorlmpl;
import py.com.prestosoftware.facepet.domain.repository.CityRepository;
import py.com.prestosoftware.facepet.ui.cities.CityContract;
import py.com.prestosoftware.facepet.ui.cities.CityPresenter;

@Module
public class CityModule {


    @Provides
    @Singleton
    CityContract.CiudadesPresenter providePresenter(CityInteractor interactor){//pantalla
        return new CityPresenter(interactor);
    }
    @Provides
    @Singleton
    CityInteractor provideInteractor(CityRepository repository){//Intermediario entre pantalla y datos
        return new CityInteractorlmpl(repository);
    }
    @Provides
    @Singleton
    CityRepository provideRepository(FacePetService service){//Datos
        return new CityDataRepository(service);
    }

}
