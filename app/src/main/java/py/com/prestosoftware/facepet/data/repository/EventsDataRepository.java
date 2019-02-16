package py.com.prestosoftware.facepet.data.repository;


import java.util.List;
import javax.inject.Inject;
import py.com.prestosoftware.facepet.data.model.Evento;
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
    public Observable<List<Evento>> getEvents() {
        return service.getEvents();
    }

    @Override
    public Observable<Boolean> setFav(int idUsuario, int idEvento) {
        return service.setFav(idUsuario,idEvento);
    }
}
