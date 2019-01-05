package py.com.prestosoftware.facepet.ui.users.login;

import javax.inject.Inject;
import py.com.prestosoftware.facepet.data.model.Login;
import py.com.prestosoftware.facepet.domain.interactor.UserInteractor;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class LoginPresenter implements LoginContract.LoginPresenter {

    private LoginContract.LoginView view;
    private CompositeSubscription subscription;

    private UserInteractor interactor;

    @Inject
    public LoginPresenter(UserInteractor interactor) {
        this.interactor = interactor;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void attachView(LoginContract.LoginView t) {
        this.view = t;
        this.view=t;
        this.subscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        this.subscription.clear();
    }

    @Override
    public void loginUser(Login login) {
        view.showProgress();
        subscription.add(
                interactor.loginUser(login)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        token -> {
                            view.hideProgress();
                            view.goToMainActivity(token);
                        },
                        error -> {
                            view.hideProgress();
                            view.onEntityError(error.getLocalizedMessage()); //CAMBIAR EN PROD
                        }
                ));

//        subscription.add(
//                service.sigIn(login)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Token>() {
//                    @Override
//                    public void onCompleted() {
//                        view.hideProgress();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        view.hideProgress();
//                        view.onEntityError(e.getLocalizedMessage()); //CAMBIAR EN PROD
//                    }
//
//                    @Override
//                    public void onNext(Token token) {
//                        view.goToMainActivity(token);
//                    }
//                })
//        );
    }

    @Override
    public void goToRegister() {
        view.goToRegisterActivity();
    }

}
