package py.com.prestosoftware.facepet.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import py.com.prestosoftware.facepet.data.remote.FacePetService;
import py.com.prestosoftware.facepet.data.repository.PetShopDataRepository;
import py.com.prestosoftware.facepet.domain.interactor.PetShopInteractor;
import py.com.prestosoftware.facepet.domain.interactor.PetShopInteractorlmpl;
import py.com.prestosoftware.facepet.domain.repository.PetShopRepository;
import py.com.prestosoftware.facepet.ui.petshop.PetShopContract;
import py.com.prestosoftware.facepet.ui.petshop.PetShopPresenter;

@Module
public class PetShopModule {

   @Provides
   @Singleton
    PetShopContract.PetShopPresenter providePresenter(PetShopInteractor interactor){//pantalla
        return new PetShopPresenter(interactor);
    }
    @Provides
    @Singleton
    PetShopInteractor provideInteractor(PetShopRepository repository){//Intermediario entre pantalla y datos
       return new PetShopInteractorlmpl(repository);
    }
    @Provides
    @Singleton
    PetShopRepository provideRepository(FacePetService service){//Datos
       return new PetShopDataRepository(service);
    }


}
