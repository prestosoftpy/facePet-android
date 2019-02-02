package py.com.prestosoftware.facepet.di.components;

import javax.inject.Singleton;

import dagger.Component;
import py.com.prestosoftware.facepet.FacePetApplication;
import py.com.prestosoftware.facepet.di.modules.ApplicationModule;
import py.com.prestosoftware.facepet.di.modules.CityModule;
import py.com.prestosoftware.facepet.di.modules.DonationModule;
import py.com.prestosoftware.facepet.di.modules.NetworkModule;
import py.com.prestosoftware.facepet.di.modules.PetShopModule;
import py.com.prestosoftware.facepet.di.modules.ReservationsModule;
import py.com.prestosoftware.facepet.di.modules.UserModule;
import py.com.prestosoftware.facepet.ui.Donations.DonationsActivity;
import py.com.prestosoftware.facepet.ui.Petshop.PetShopFragment;
import py.com.prestosoftware.facepet.ui.cities.CityFragment;
import py.com.prestosoftware.facepet.ui.reservations.List.ReservationListFragment;
import py.com.prestosoftware.facepet.ui.reservations.Register.RegisterReservationsActivity;
import py.com.prestosoftware.facepet.ui.users.login.LoginActivity;
import py.com.prestosoftware.facepet.ui.users.profile.ProfileActivity;
import py.com.prestosoftware.facepet.ui.users.register.RegisterActivity;


@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                NetworkModule.class,
                UserModule.class,
                PetShopModule.class,
                CityModule.class,
                ReservationsModule.class,
                DonationModule.class
        }
)



    public interface ApplicationComponent {

        void inject(FacePetApplication facePetApplication);

        void inject(LoginActivity loginActivity);

        void inject(RegisterActivity registerActivity);

        void inject(ProfileActivity profileActivity);

        void inject(PetShopFragment petShopFragment);

        void inject(CityFragment cityFragment);

        void inject(RegisterReservationsActivity registerReservationsActivity);

        void inject(ReservationListFragment reservationListFragment);

        void inject(DonationsActivity donationsActivity);


    }
