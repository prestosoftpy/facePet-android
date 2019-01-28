package py.com.prestosoftware.facepet.domain.repository;

import py.com.prestosoftware.facepet.data.model.Reservas;
import rx.Observable;

public interface ReservationsRepository {


    Observable<Reservas> reservasdata(Reservas reservas);


}
