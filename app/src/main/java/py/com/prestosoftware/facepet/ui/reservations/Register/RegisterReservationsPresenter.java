package py.com.prestosoftware.facepet.ui.reservations.Register;


import android.util.Log;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Reservas;
import py.com.prestosoftware.facepet.domain.interactor.ReservationsInteractor;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class RegisterReservationsPresenter implements RegisterReservationsContract.RerservationsPresenter {

    private RegisterReservationsContract.ReservationsView view;
    private ReservationsInteractor interactor;
    private CompositeSubscription subscription;
    @Inject
    RegisterReservationsContract.RerservationsPresenter presenter;

    @Inject
    public RegisterReservationsPresenter(ReservationsInteractor interactor) {
        this.interactor = interactor;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void attachView(RegisterReservationsContract.ReservationsView t) {
        this.view = t;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        this.subscription.clear();
    }

    @Override
    public void saveReservation(Reservas reservitas) {
        Log.e("ESTE ES EL OBJ", reservitas.toString());
        view.showProgress();
        subscription.add(
                interactor.reservasdata(reservitas)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        //.doOnNext(reserva -> interactor.saveToDb(reserva))
                        .subscribe(reserva -> {
                                    interactor.saveToDb(reserva);
                                    view.hideProgress();
                                    // presenter.saveReservation(reserva);
                                    view.gotoMainActivity();
                                },
                                error -> {
                                    view.hideProgress();
                                    view.onEntityError(error.getLocalizedMessage()); //CAMBIAR EN PROD
                                }
                        )
        );
    }

}
