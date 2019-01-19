package py.com.prestosoftware.facepet.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Ciudades;
import py.com.prestosoftware.facepet.domain.repository.CityRepository;
import rx.Observable;

public class CityInteractorlmpl implements CityInteractor {

    private CityRepository repository;
    @Inject
    public CityInteractorlmpl(CityRepository repository){

        this.repository= repository;
    }


    @Override
    public Observable<List<Ciudades>> getCiudades() {
        return repository.getCiudades();
    }
}

