package py.com.prestosoftware.facepet.ui.reservations.List;

import java.util.List;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Reservas;
import py.com.prestosoftware.facepet.domain.interactor.ReservationsInteractor;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class ReservationListPresenter implements ReservationListContract.ReservationListPresenter {

    private CompositeSubscription mSubscription;
    private ReservationListContract.ReservationsView view;

    private ReservationsInteractor interactor;
    @Inject
    public ReservationListPresenter(ReservationsInteractor interactor){
        this.interactor= interactor;
        this.mSubscription= new CompositeSubscription();

    }
    @Override
    public void getReservas() {
        this.view.showProgress();
        interactor.getReserva()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        reservas -> {
                            view.loadReservas(reservas);
                            view.hideProgress();
                        },error -> {
                            view.hideProgress();
                            view.onEntityError(error.getMessage());
                        }
                );
    }

    @Override
    public void attachView(ReservationListContract.ReservationsView t) {
        this.view=t;
    }

    @Override
    public void detachView() {
        this.mSubscription.clear();
    }
}
