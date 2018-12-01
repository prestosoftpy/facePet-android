package py.com.prestosoftware.facepet.di.components;

import javax.inject.Singleton;

import dagger.Component;
import py.com.prestosoftware.facepet.FacePetApplication;
import py.com.prestosoftware.facepet.di.modules.ApplicationModule;
import py.com.prestosoftware.facepet.di.modules.NetworkModule;
import py.com.prestosoftware.facepet.di.modules.UserModule;
import py.com.prestosoftware.facepet.ui.users.login.LoginActivity;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                NetworkModule.class,
                UserModule.class
        }
)

public interface ApplicationComponent {
    void inject(FacePetApplication facePetApplication);

    void inject(LoginActivity loginActivity);
}
