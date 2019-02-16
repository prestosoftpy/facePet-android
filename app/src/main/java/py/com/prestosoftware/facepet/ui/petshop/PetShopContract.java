package py.com.prestosoftware.facepet.ui.petshop;

import java.util.List;

import py.com.prestosoftware.facepet.data.model.Empresa;
import py.com.prestosoftware.facepet.ui.base.Presenter;
import py.com.prestosoftware.facepet.ui.base.View;

public interface PetShopContract {

    interface  PetShopView extends View{
        void loadEmpresas(List<Empresa> empresas);
    }

    interface  PetShopPresenter extends Presenter<PetShopView>{
        void getEmpresas();
    }

}
