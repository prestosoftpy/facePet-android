package py.com.prestosoftware.facepet.domain.interactor;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Donaciones;
import py.com.prestosoftware.facepet.domain.repository.DonationRepository;
import rx.Observable;

public class DonationInteractorlmpl implements DonationInteractor {

    private DonationRepository repository;


    @Inject
    public DonationInteractorlmpl(DonationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Donaciones> registerDonation(Donaciones donaciones) {
        return repository.registerDonation(donaciones);
    }
}
