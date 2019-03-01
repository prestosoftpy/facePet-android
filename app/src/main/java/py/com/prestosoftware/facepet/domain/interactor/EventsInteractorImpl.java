package py.com.prestosoftware.facepet.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Evento;
import py.com.prestosoftware.facepet.data.model.Favoritos;
import py.com.prestosoftware.facepet.domain.repository.EventsRepository;
import rx.Observable;

public class EventsInteractorImpl implements EventsInteractor {

    private EventsRepository repository;

    @Inject
    public EventsInteractorImpl(EventsRepository repository){
        this.repository = repository;
    }

    @Override
    public Observable<List<Evento>> getEvents() {
        return repository.getEvents();
    }

    @Override
    public Observable<Favoritos> setFav(int idUsuario, int idEvento) {
        return repository.setFav(idUsuario,idEvento);
    }
}
