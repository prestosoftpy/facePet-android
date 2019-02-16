package py.com.prestosoftware.facepet.domain.interactor;

import java.util.List;

import py.com.prestosoftware.facepet.data.model.Evento;
import rx.Observable;

public interface EventsInteractor {
    Observable<List<Evento>> getEvents();

    Observable<Boolean> setFav(int idUsuario, int idEvento);
}
