package py.com.prestosoftware.facepet.ui.reservations.Register;

import py.com.prestosoftware.facepet.data.model.Reservas;
import py.com.prestosoftware.facepet.ui.base.Presenter;
import py.com.prestosoftware.facepet.ui.base.View;

public interface RegisterReservationsContract {

    interface RerservationsPresenter extends Presenter<ReservationsView> {//que hara con los datos, en este caso guardar la reserva
        void saveReservation(Reservas reservas);

    }

    interface ReservationsView extends View {//A que vista ira
        void gotoMainActivity();
    }

}
