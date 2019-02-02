package py.com.prestosoftware.facepet.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Reservas;
import py.com.prestosoftware.facepet.domain.repository.ReservationsRepository;
import rx.Observable;

public class ReservationsInteractorlmpl implements ReservationsInteractor {

    private ReservationsRepository repository;


    @Inject
    public ReservationsInteractorlmpl(ReservationsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Reservas> reservasdata(Reservas reservas) {
        return repository.reservasdata(reservas);
    }

    @Override
    public void saveToDb(Reservas reserva) {

    }

    @Override
    public Observable<List<Reservas>> getReserva() {
        return repository.getReserva();
    }

}
