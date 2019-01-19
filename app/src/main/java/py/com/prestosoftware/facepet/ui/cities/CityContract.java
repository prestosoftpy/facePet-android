package py.com.prestosoftware.facepet.ui.cities;

import java.util.List;

import py.com.prestosoftware.facepet.data.model.Ciudades;
import py.com.prestosoftware.facepet.ui.base.Presenter;
import py.com.prestosoftware.facepet.ui.base.View;

public interface CityContract {

    interface  CiudadesView extends View {
        void loadCiudades(List<Ciudades> ciudades);
    }

    interface  CiudadesPresenter extends Presenter<CiudadesView> {
        void getCiudades();
    }

}
