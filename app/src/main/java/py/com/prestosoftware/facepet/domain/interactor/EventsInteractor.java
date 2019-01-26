package py.com.prestosoftware.facepet.domain.interactor;

import java.util.List;
import rx.Observable;

import py.com.prestosoftware.facepet.data.model.Eventos;

public interface EventsInteractor {
    Observable<List<Eventos>> getEvents();
}
