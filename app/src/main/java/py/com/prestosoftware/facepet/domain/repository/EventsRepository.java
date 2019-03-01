package py.com.prestosoftware.facepet.domain.repository;

import java.util.List;

import py.com.prestosoftware.facepet.data.model.Evento;
import py.com.prestosoftware.facepet.data.model.Favoritos;
import rx.Observable;

public interface EventsRepository {

    Observable<List<Evento>> getEvents();

    Observable<Favoritos> setFav(int idUsuario, int idEvento);
}
