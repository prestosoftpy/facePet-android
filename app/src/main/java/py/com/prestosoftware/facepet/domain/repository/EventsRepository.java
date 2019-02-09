package py.com.prestosoftware.facepet.domain.repository;

import java.util.List;

import py.com.prestosoftware.facepet.data.model.Eventos;
import rx.Observable;

public interface EventsRepository {

    Observable<List<Eventos>> getEvents();

    Observable<Boolean> setFav(int idUsuario,int idEvento);
}
