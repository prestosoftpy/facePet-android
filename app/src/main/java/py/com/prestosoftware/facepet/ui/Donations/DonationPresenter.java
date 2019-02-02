package py.com.prestosoftware.facepet.ui.Donations;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Donaciones;
import py.com.prestosoftware.facepet.domain.interactor.DonationInteractor;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class DonationPresenter implements DonationContract.DonationPresenter {


    private DonationContract.DonationView view;
    private DonationInteractor interactor;
    private CompositeSubscription subscription;

    @Inject
    public DonationPresenter(DonationInteractor interactor) {
        this.interactor = interactor;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void attachView(DonationContract.DonationView t) {
        this.view=t;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        this.subscription.clear();
    }

    @Override
    public void registerDonation(Donaciones donaciones) {
        view.showProgress();
        subscription.add(
                interactor.registerDonation(donaciones)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                       .subscribe(
                        Donaciones -> {
                            view.hideProgress();
                            view.goToMainActivity();
                       },
                       error -> {
                           view.hideProgress();
                           view.onEntityError(error.getLocalizedMessage()); //CAMBIAR EN PROD
                        }
               )
                );
    }

}
