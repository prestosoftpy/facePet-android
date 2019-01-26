package py.com.prestosoftware.facepet.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Empresa;
import py.com.prestosoftware.facepet.domain.repository.PetShopRepository;
import rx.Observable;

public class PetShopInteractorImpl implements PetShopInteractor {

    private PetShopRepository repository;

    @Inject
    public PetShopInteractorImpl(PetShopRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<List<Empresa>> getEmpresas() {
        return repository.getEmpresas();
    }
}
