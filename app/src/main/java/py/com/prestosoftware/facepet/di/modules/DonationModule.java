package py.com.prestosoftware.facepet.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import py.com.prestosoftware.facepet.data.remote.FacePetService;
import py.com.prestosoftware.facepet.data.repository.DonationDataRepository;
import py.com.prestosoftware.facepet.domain.interactor.DonationInteractor;
import py.com.prestosoftware.facepet.domain.interactor.DonationInteractorlmpl;
import py.com.prestosoftware.facepet.domain.repository.DonationRepository;
import py.com.prestosoftware.facepet.ui.Donations.DonationContract;
import py.com.prestosoftware.facepet.ui.Donations.DonationPresenter;

 @Module
public class DonationModule {

    @Provides
    @Singleton
    DonationRepository provideRepository(FacePetService service) {
        return new DonationDataRepository(service);
    }

    @Provides
    @Singleton
    DonationInteractor provideInteractor(DonationRepository repository) {
        return new DonationInteractorlmpl(repository);
    }

    @Provides
    @Singleton
    DonationContract.DonationPresenter provideProfilePresenter(DonationInteractor interactor) {
        return new DonationPresenter(interactor);
    }
}
