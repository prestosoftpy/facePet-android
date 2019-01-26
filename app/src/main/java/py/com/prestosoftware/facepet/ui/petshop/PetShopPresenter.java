package py.com.prestosoftware.facepet.ui.petshop;

import android.util.Log;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.domain.interactor.PetShopInteractor;
import py.com.prestosoftware.facepet.ui.petshop.dummy.PetShopContract;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class PetShopPresenter implements PetShopContract.PetShopPresenter {

    private CompositeSubscription mSubscription;
    private PetShopContract.PetShopView view;
    private PetShopInteractor interactor;

    @Inject
    public PetShopPresenter(PetShopInteractor interactor){
        this.interactor = interactor;
        this.mSubscription = new CompositeSubscription();
    }



    @Override
    public void getEmpresas() {
        this.view.showProgress();
        interactor.getEmpresas()
            .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        empresas -> {
                            view.loadEmpresas(empresas);
                            view.hideProgress();
                        },
                        error -> {
                            view.hideProgress();
                            view.onEntityError(error.getLocalizedMessage());
                        }
                );
    }

    @Override
    public void attachView(PetShopContract.PetShopView t) {
        this.view = t;
    }

    @Override
    public void detachView() {
        this.mSubscription.clear();
    }
}
