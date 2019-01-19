package py.com.prestosoftware.facepet.data.repository;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Reservas;
import py.com.prestosoftware.facepet.data.remote.FacePetService;
import py.com.prestosoftware.facepet.domain.repository.ReservationsRepository;
import rx.Observable;

public class ReservationsDataRepository implements ReservationsRepository {

    private FacePetService service;

    @Inject
    public ReservationsDataRepository(FacePetService service) {
        this.service= service;
    }

    @Override
    public Observable<Reservas> reservasdata(Reservas reservas) {
        return service.submitReservation(reservas);
    }
}
