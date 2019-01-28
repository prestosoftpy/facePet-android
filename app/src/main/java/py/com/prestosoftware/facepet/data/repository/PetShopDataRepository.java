package py.com.prestosoftware.facepet.data.repository;

import java.util.List;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Empresa;
import py.com.prestosoftware.facepet.data.remote.FacePetService;
import py.com.prestosoftware.facepet.domain.repository.PetShopRepository;
import rx.Observable;

public class PetShopDataRepository implements PetShopRepository {

    @Inject
    FacePetService service;

    public  PetShopDataRepository(FacePetService service){
        this.service= service;
    }


    @Override
    public Observable<List<Empresa>> getempresas() {
        return service.getEmpresas();
    }
}
