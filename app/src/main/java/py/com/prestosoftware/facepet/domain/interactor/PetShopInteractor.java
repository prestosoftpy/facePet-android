package py.com.prestosoftware.facepet.domain.interactor;


import java.util.List;

import py.com.prestosoftware.facepet.data.model.Empresa;
import rx.Observable;

public interface PetShopInteractor {

    Observable<List<Empresa>> getempresa();
}
