package py.com.prestosoftware.facepet.ui.users.register;

import javax.inject.Inject;

import py.com.prestosoftware.facepet.data.model.Usuario;
import py.com.prestosoftware.facepet.domain.interactor.UserInteractor;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class RegisterPresenter implements RegisterContract.RegisterPresenter{

    private RegisterContract.RegisterView view;
    private UserInteractor interactor;
    private CompositeSubscription subscription;

    @Inject
    public RegisterPresenter(UserInteractor interactor) {
        this.interactor = interactor;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        this.subscription.clear();
    }

    @Override
    public void attachView(RegisterContract.RegisterView t) {
        this.view = t;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void registerUser(Usuario usuario) {
        view.showProgress();
        subscription.add(
                interactor.registerUser(usuario)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        token -> {
                            view.hideProgress();
                            view.goToMainActivity();
                        },
                        error -> {
                            view.hideProgress();
                            view.onEntityError(error.getLocalizedMessage()); //CAMBIAR EN PRODUCCION
                        }
                )
        );
    }




}
