package py.com.prestosoftware.facepet.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Eventos;
import py.com.prestosoftware.facepet.domain.repository.EventsRepository;
import rx.Observable;

public class EventsInteractorImpl implements EventsInteractor {

    private EventsRepository repository;

    @Inject
    public EventsInteractorImpl(EventsRepository repository){
        this.repository = repository;
    }

    @Override
    public Observable<List<Eventos>> getEvents() {
        return repository.getEvents();
    }

    @Override
    public Observable<Boolean> setFav(int idUsuario, int idEvento) {
        return repository.setFav(idUsuario,idEvento);
    }
}
