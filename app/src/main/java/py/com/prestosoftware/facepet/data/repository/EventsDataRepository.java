package py.com.prestosoftware.facepet.data.repository;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Eventos;
import py.com.prestosoftware.facepet.data.model.Usuario;
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
        List<Eventos> eventosList = new List<Eventos>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Eventos> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Eventos eventos) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Eventos> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, @NonNull Collection<? extends Eventos> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Eventos get(int index) {
                return null;
            }

            @Override
            public Eventos set(int index, Eventos element) {
                return null;
            }

            @Override
            public void add(int index, Eventos element) {

            }

            @Override
            public Eventos remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<Eventos> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Eventos> listIterator(int index) {
                return null;
            }

            @NonNull
            @Override
            public List<Eventos> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        Eventos eventos = new Eventos();
        eventos.setId(1);
        eventos.setCiudadId(1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2019-01-26";
        try {
            Date date       = format.parse(dateString);
            eventos.setFecha(date);
        }catch (Exception e){
            e.getLocalizedMessage();
        }
        eventos.setDescripcion("asdfasdfasdfasdfads");
        eventos.setImagenUrl("https://imgredirect.milanuncios.com/fg/2399/28/rottweiler/Cachorro-disponible-239928484_1.jpg");
        eventos.setLatitud(-27.32156f);
        eventos.setLongitud(-54.32156f);
        eventos.setNombre("Perrito");
        Usuario usuario = new Usuario();
        usuario.setNombre("Nestor Espinola");
        eventos.setUsuario(usuario);
        eventosList.add(0,eventos);

        return service.getEvents();
    }

    @Override
    public Observable<Boolean> setFav(int idUsuario, int idEvento) {
        return service.setFav(idUsuario,idEvento);
    }
}
