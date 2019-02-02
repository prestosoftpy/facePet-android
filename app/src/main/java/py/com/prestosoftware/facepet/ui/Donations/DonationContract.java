package py.com.prestosoftware.facepet.ui.Donations;

import py.com.prestosoftware.facepet.data.model.Donaciones;
import py.com.prestosoftware.facepet.ui.base.Presenter;
import py.com.prestosoftware.facepet.ui.base.View;

public interface DonationContract {

    interface DonationPresenter extends Presenter<DonationView> {
        void registerDonation(Donaciones donaciones);
    }

    interface DonationView extends View {
        void goToMainActivity();
    }
}
