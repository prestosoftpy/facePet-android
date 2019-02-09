package py.com.prestosoftware.facepet.ui.reservations.List;

import java.util.List;

import py.com.prestosoftware.facepet.data.model.Reservas;
import py.com.prestosoftware.facepet.ui.base.Presenter;
import py.com.prestosoftware.facepet.ui.base.View;

public interface ReservationListContract {

    interface  ReservationsView extends View {
        void loadReservas(List<Reservas> reservas);//que hara con los datos, este caso cargara la lista
    }

    interface  ReservationListPresenter extends Presenter<ReservationsView> {//metodo para obtener las reservas
        void getReservas();
    }


}
