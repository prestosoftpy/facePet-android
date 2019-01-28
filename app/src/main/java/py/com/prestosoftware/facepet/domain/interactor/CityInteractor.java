package py.com.prestosoftware.facepet.domain.interactor;

import java.util.List;

import py.com.prestosoftware.facepet.data.model.Ciudades;
import rx.Observable;

public interface CityInteractor {

    Observable<List<Ciudades>> getCiudades();
}
