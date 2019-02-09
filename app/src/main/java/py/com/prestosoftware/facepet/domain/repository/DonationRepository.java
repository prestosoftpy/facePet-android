package py.com.prestosoftware.facepet.domain.repository;

import py.com.prestosoftware.facepet.data.model.Donaciones;
import rx.Observable;

public interface DonationRepository {

    Observable<Donaciones> registerDonation(Donaciones donaciones);
}
