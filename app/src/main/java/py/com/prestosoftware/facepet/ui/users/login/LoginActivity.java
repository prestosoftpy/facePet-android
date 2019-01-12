package py.com.prestosoftware.facepet.ui.users.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import javax.inject.Inject;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import py.com.prestosoftware.facepet.FacePetApplication;
import py.com.prestosoftware.facepet.R;
import py.com.prestosoftware.facepet.data.local.FacePetPreference;
import py.com.prestosoftware.facepet.data.model.Login;
import py.com.prestosoftware.facepet.data.model.Token;
import py.com.prestosoftware.facepet.ui.main.MainActivity;
import py.com.prestosoftware.facepet.ui.users.register.RegisterActivity;
import py.com.prestosoftware.facepet.ui.users.register.RegisterContract;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.edtEmail) EditText mEdtEmail;
    @BindView(R.id.edtClave) EditText mEdtClave;
    @BindView(R.id.progress_dialog) ProgressBar mProgressDialog;

    @Inject LoginContract.LoginPresenter presenter;

    @Inject RegisterContract.RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Binding de los componentes de la UI
        ButterKnife.bind(this);
        setupInjection();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();

    }

    @Override
    public void goToMainActivity(Token token) {
        FacePetPreference.setSesion(this);
        FacePetPreference.setToken(this,token.getToken());
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void goToRegisterActivity() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    /*@Override
    public void goToPerfilActivity() {
        startActivity(new Intent(this,ProfileActivity.class));}
*/



    @Override
    public void showProgress() {
        mProgressDialog.setVisibility(android.view.View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        mProgressDialog.setVisibility(android.view.View.GONE);

    }

    @Override
    public void onEntityError(String error) {

    }

    //Local Methods
    @OnClick(R.id.btnLogin)
    public void loginUser() {
        String email = mEdtEmail.getText().toString();
        String clave = mEdtClave.getText().toString();

        if (!email.isEmpty() && !clave.isEmpty()) {

            Login login = new Login();
            login.setEmail(email);
            login.setClave(clave);
            presenter.loginUser(login);
        }
    }

    @OnClick(R.id.txtRegistro)
    public void goToRegister(){
        startActivity(new Intent(this,RegisterActivity.class));
    }

    @OnCheckedChanged(R.id.show_password)
    public void showPassword(boolean checked) {
         mEdtClave.setTransformationMethod(checked ?
                 HideReturnsTransformationMethod.getInstance() :
                 PasswordTransformationMethod.getInstance());
    }

    private void setupInjection() {
        FacePetApplication app = (FacePetApplication) getApplication();
        app.getGraph().inject(this);
    }

}