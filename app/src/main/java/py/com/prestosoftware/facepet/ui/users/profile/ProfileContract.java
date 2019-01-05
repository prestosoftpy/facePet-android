package py.com.prestosoftware.facepet.ui.users.profile;

import py.com.prestosoftware.facepet.data.model.Usuario;
import py.com.prestosoftware.facepet.ui.base.Presenter;
import py.com.prestosoftware.facepet.ui.base.View;


public interface ProfileContract {

    interface ProfilePresenter extends Presenter<ProfileView> {
        void UserData(int usuarioid);

    }

    interface   ProfileView extends View {

        void getProfile(Usuario usuario);
    }

}
