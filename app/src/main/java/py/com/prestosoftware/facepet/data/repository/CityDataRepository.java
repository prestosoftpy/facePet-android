package py.com.prestosoftware.facepet.data.repository;

import java.util.List;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Ciudades;
import py.com.prestosoftware.facepet.data.remote.FacePetService;
import py.com.prestosoftware.facepet.domain.repository.CityRepository;
import rx.Observable;

public class CityDataRepository  implements CityRepository {


    @Inject
    FacePetService service;

    public  CityDataRepository(FacePetService service){
        this.service= service;
    }


    @Override
    public Observable<List<Ciudades>> getCiudades() {
        return service.getCiudades();
    }
}
