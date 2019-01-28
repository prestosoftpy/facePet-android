package py.com.prestosoftware.facepet.ui.reservas;


import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Reservas;
import py.com.prestosoftware.facepet.domain.interactor.ReservationsInteractor;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class ReservationsPresenter implements ReservationsContract.RerservationsPresenter {

    private ReservationsContract.ReservationsView view;
    private ReservationsInteractor interactor;
    private CompositeSubscription subscription;

    @Inject
    public ReservationsPresenter(ReservationsInteractor interactor) {
        this.interactor = interactor;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void attachView(ReservationsContract.ReservationsView t) {
        this.view=t;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        this.subscription.clear();
    }

    @Override
    public void saveReservation(Reservas reservitas) {
        view.showProgress();
        subscription.add(
                interactor.reservasdata(reservitas)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        //.doOnNext(reserva -> interactor.saveToDb(reserva))
                        .subscribe(reserva -> {
                                    interactor.saveToDb(reserva);
                                    view.hideProgress();
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
