package py.com.prestosoftware.facepet.ui.users.login;

import py.com.prestosoftware.facepet.data.model.Login;
import py.com.prestosoftware.facepet.data.model.Token;
import py.com.prestosoftware.facepet.data.model.Usuario;
import py.com.prestosoftware.facepet.ui.base.Presenter;
import py.com.prestosoftware.facepet.ui.base.View;

public interface LoginContract {

    interface LoginPresenter extends Presenter<LoginView> {
        void loginUser(Login login);
        void goToRegister();
    }

    interface LoginView extends View {
        void goToMainActivity(Usuario usuario);
        void goToRegisterActivity();
    }

}
