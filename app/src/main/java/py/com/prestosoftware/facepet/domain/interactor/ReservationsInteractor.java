package py.com.prestosoftware.facepet.domain.interactor;

import java.util.List;

import py.com.prestosoftware.facepet.data.model.Reservas;
import rx.Observable;

public interface ReservationsInteractor {

    Observable<Reservas> reservasdata(Reservas reservas);

    void saveToDb(Reservas reserva);

    Observable<List<Reservas>> getReserva();
}
