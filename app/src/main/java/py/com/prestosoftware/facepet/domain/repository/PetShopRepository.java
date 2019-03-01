package py.com.prestosoftware.facepet.domain.repository;

import java.util.List;

import py.com.prestosoftware.facepet.data.model.Empresa;
import rx.Observable;

public interface PetShopRepository {

    Observable<List<Empresa>> getEmpresas();
}
