package py.com.prestosoftware.facepet.di.components;

import javax.inject.Singleton;

import dagger.Component;
import py.com.prestosoftware.facepet.FacePetApplication;
import py.com.prestosoftware.facepet.di.modules.ApplicationModule;
import py.com.prestosoftware.facepet.di.modules.CityModule;
import py.com.prestosoftware.facepet.di.modules.NetworkModule;
import py.com.prestosoftware.facepet.di.modules.PetShopModule;
import py.com.prestosoftware.facepet.di.modules.UserModule;
import py.com.prestosoftware.facepet.ui.Petshop.PetShopFragment;
import py.com.prestosoftware.facepet.ui.cities.CityFragment;
import py.com.prestosoftware.facepet.ui.users.login.LoginActivity;
//<<<<<<< HEAD
//=======
import py.com.prestosoftware.facepet.ui.users.profile.ProfileActivity;
import py.com.prestosoftware.facepet.ui.users.register.RegisterActivity;


@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                NetworkModule.class,
                UserModule.class,
                PetShopModule.class,
                CityModule.class
        }
)



    public interface ApplicationComponent {

        void inject(FacePetApplication facePetApplication);

        void inject(LoginActivity loginActivity);

        void inject(RegisterActivity registerActivity);

        void inject(ProfileActivity profileActivity);

        void inject(PetShopFragment petShopFragment);

        void inject(CityFragment cityFragment);

    }
