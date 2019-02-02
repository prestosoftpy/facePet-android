package py.com.prestosoftware.facepet.data.repository;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Donaciones;
import py.com.prestosoftware.facepet.data.remote.FacePetService;
import py.com.prestosoftware.facepet.domain.repository.DonationRepository;
import rx.Observable;

public class DonationDataRepository implements DonationRepository {

    private FacePetService service;

    @Inject
    public DonationDataRepository(FacePetService service) {
        this.service = service;
    }

    @Override
    public Observable<Donaciones> registerDonation(Donaciones donaciones) {
        return service.sigDonation(donaciones);
    }
}
