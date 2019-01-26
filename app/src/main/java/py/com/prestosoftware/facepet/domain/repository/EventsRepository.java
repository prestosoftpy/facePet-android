package py.com.prestosoftware.facepet.domain.repository;

import java.util.List;

import py.com.prestosoftware.facepet.data.model.Eventos;
import py.com.prestosoftware.facepet.data.model.Usuario;
import rx.Observable;

public interface EventsRepository {

    Observable<List<Eventos>> getEvents();
}
