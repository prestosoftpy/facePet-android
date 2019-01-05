package py.com.prestosoftware.facepet.ui.users.register;

import py.com.prestosoftware.facepet.data.model.Usuario;
import py.com.prestosoftware.facepet.ui.base.Presenter;
import py.com.prestosoftware.facepet.ui.base.View;

public interface RegisterContract {

    interface RegisterPresenter extends Presenter<RegisterView>{
        void registerUser(Usuario usuario);
    }

    interface RegisterView extends View{
        void goToMainActivity();
        //void goToProfileActivity();
    }
}
