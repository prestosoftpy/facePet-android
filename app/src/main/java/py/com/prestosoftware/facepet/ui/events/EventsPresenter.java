package py.com.prestosoftware.facepet.ui.events;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.domain.interactor.EventsInteractor;
import py.com.prestosoftware.facepet.ui.events.dummy.EventsContract;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class EventsPresenter implements EventsContract.EventsPresenter {

    private CompositeSubscription mSubscription;
    private EventsContract.EventsView view;
    private EventsInteractor interactor;

    @Inject
    public EventsPresenter(EventsInteractor interactor){
        this.interactor = interactor;
        this.mSubscription = new CompositeSubscription();
    }


    @Override
    public void getEvents() {
        this.view.showProgress();
        interactor.getEvents()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        eventos -> {
                            view.loadEvents(eventos);
                            view.hideProgress();
                        },
                        error -> {
                            view.hideProgress();
                            view.onEntityError(error.getLocalizedMessage());
                        }
                );

    }

    @Override
    public void setFav(int idUsuario, int idEvento) {
        this.view.showProgress();
        interactor.setFav(idUsuario,idEvento)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        fav -> {
                            view.hideProgress();
                            view.confirmFav(fav);
                        },
                        error -> {
                            view.hideProgress();
                            view.onEntityError(error.getLocalizedMessage());
                        }
                );
    }

    @Override
    public void attachView(EventsContract.EventsView t) {
        this.view = t;
    }

    @Override
    public void detachView() {
        this.mSubscription.clear();
    }
}
