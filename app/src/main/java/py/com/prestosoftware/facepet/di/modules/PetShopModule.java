package py.com.prestosoftware.facepet.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import py.com.prestosoftware.facepet.data.remote.FacePetService;
import py.com.prestosoftware.facepet.data.repository.PetShopDataRepository;
import py.com.prestosoftware.facepet.domain.interactor.PetShopInteractor;
import py.com.prestosoftware.facepet.domain.interactor.PetShopInteractorImpl;
import py.com.prestosoftware.facepet.domain.repository.PetShopRepository;
import py.com.prestosoftware.facepet.ui.petshop.PetShopPresenter;
import py.com.prestosoftware.facepet.ui.petshop.dummy.PetShopContract;

@Module
public class PetShopModule {

    @Provides
    @Singleton
    PetShopContract.PetShopPresenter providePresenter(PetShopInteractor interactor){
        return new PetShopPresenter(interactor);
    }

    @Provides
    @Singleton
    PetShopInteractor provideInteractor(PetShopRepository repository){
        return new PetShopInteractorImpl(repository);
    }

    @Provides
    @Singleton
    PetShopRepository provideRepository(FacePetService service){
        return new PetShopDataRepository(service);
    }


}
