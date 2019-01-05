package py.com.prestosoftware.facepet.ui.users.profile;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Usuario;
import py.com.prestosoftware.facepet.domain.interactor.UserInteractor;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class ProfilePresenter implements ProfileContract.ProfilePresenter {

    private ProfileContract.ProfileView view;
    private UserInteractor interactor;
    private CompositeSubscription subscription;

    @Inject
    public ProfilePresenter(UserInteractor interactor) {
        this.interactor = interactor;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        this.subscription.clear();
    }

    @Override
    public void attachView(ProfileContract.ProfileView t) {
        this.view = t;
        this.subscription = new CompositeSubscription();
    }


    @Override
    public void UserData(int usuarioid) {
        view.showProgress();
        subscription.add(
                 interactor.UserData(usuarioid)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                usuario -> {
                                    view.hideProgress();
                                    view.getProfile(usuario);

                                },
                                error -> {
                                    view.hideProgress();
                                    view.onEntityError(error.getLocalizedMessage()); //CAMBIAR EN PRODUCCION
                                }
                        )
        );
    }

}
