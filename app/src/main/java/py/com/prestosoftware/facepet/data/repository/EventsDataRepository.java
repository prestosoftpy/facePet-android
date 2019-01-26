package py.com.prestosoftware.facepet.data.repository;

import java.util.List;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Eventos;
import py.com.prestosoftware.facepet.data.remote.FacePetService;
import py.com.prestosoftware.facepet.domain.repository.EventsRepository;
import rx.Observable;

public class EventsDataRepository implements EventsRepository {

    private FacePetService service;

    @Inject
    public EventsDataRepository(FacePetService service){
        this.service = service;
    }

    @Override
    public Observable<List<Eventos>> getEvents() {
        return service.getEvents();
    }
}
