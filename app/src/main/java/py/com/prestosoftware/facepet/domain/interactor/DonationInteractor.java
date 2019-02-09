package py.com.prestosoftware.facepet.domain.interactor;

import py.com.prestosoftware.facepet.data.model.Donaciones;
import rx.Observable;

public interface DonationInteractor {

    Observable<Donaciones> registerDonation(Donaciones donaciones);
}
