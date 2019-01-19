package py.com.prestosoftware.facepet.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Empresa;
import py.com.prestosoftware.facepet.domain.repository.PetShopRepository;
import rx.Observable;

public class PetShopInteractorlmpl implements PetShopInteractor {

    private PetShopRepository repository;
    @Inject
    public PetShopInteractorlmpl(PetShopRepository repository){

        this.repository= repository;
    }


    @Override
    public Observable<List<Empresa>> getempresa() {
        return repository.getempresas();
    }
}

