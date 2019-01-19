package py.com.prestosoftware.facepet.ui.cities;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.domain.interactor.CityInteractor;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class CityPresenter implements CityContract.CiudadesPresenter{
    private CompositeSubscription mSubscription;
    private CityContract.CiudadesView view;

    private CityInteractor interactor;
    @Inject
    public CityPresenter(CityInteractor interactor){
        this.interactor= interactor;
        this.mSubscription= new CompositeSubscription();

    }
    @Override
    public void getCiudades(){
        this.view.showProgress();
        interactor.getCiudades()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        ciudades -> {
                            view.loadCiudades(ciudades);
                            view.hideProgress();
                        },error -> {
                            view.hideProgress();
                            view.onEntityError(error.getMessage());
                        }
                );
    }

    @Override
    public void attachView(CityContract.CiudadesView t) {
        this.view=t;
    }

    @Override
    public void detachView() {
        this.mSubscription.clear();
    }

}
