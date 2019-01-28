package py.com.prestosoftware.facepet.domain.repository;

import java.util.List;

import py.com.prestosoftware.facepet.data.model.Ciudades;
import rx.Observable;

public interface CityRepository {

    Observable<List<Ciudades>> getCiudades();
}
