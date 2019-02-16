package py.com.prestosoftware.facepet.ui.users.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import py.com.prestosoftware.facepet.FacePetApplication;
import py.com.prestosoftware.facepet.R;
import py.com.prestosoftware.facepet.data.local.FacePetPreference;
import py.com.prestosoftware.facepet.data.model.Login;
import py.com.prestosoftware.facepet.data.model.Usuario;
import py.com.prestosoftware.facepet.ui.main.MainActivity;
import py.com.prestosoftware.facepet.ui.users.profile.ProfileActivity;
import py.com.prestosoftware.facepet.ui.users.register.RegisterActivity;
import py.com.prestosoftware.facepet.ui.users.register.RegisterContract;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.ProfileContainer)
    RelativeLayout profile_container;
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
        setupinjection();
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
    public void goToMainActivity(Usuario usuario) {
        if(usuario != null){
            FacePetPreference.setUsuarioID(this,usuario.getId());//trae el idusuario junto con el token
            FacePetPreference.setSesion(this);
           // FacePetPreference.setToken(this,usuario.getToken());
            startActivity(new Intent(this, MainActivity.class));
            }else{
            Snackbar.make(profile_container, "Email o Contraseña Incorrectos", Snackbar.LENGTH_LONG).show();
        }


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
        Snackbar.make(profile_container, "Email o Contraseña Incorrectos", Snackbar.LENGTH_LONG).show();
    }

    //Local Methods

    @OnClick(R.id.btnLogin)
    public void loginUser() {
        String email = mEdtEmail.getText().toString();
        String clave = mEdtClave.getText().toString();

        if (!email.isEmpty() && !clave.isEmpty()) {



           // Log.d(TAG, email);
            //Log.d(TAG, clave);

            Login login = new Login();
            login.setCorreo(email);
            login.setClave(clave);
            presenter.loginUser(login);


        }



    }
    /*public void goToProfileActivity() {
        startActivity( new Intent(this,ProfileActivity.class));
    }
*/
//

    @OnClick(R.id.txtRegistro)
    public void goToRegister(){
        startActivity(new Intent(this,RegisterActivity.class));
    }







    //@OnClick(R.id.show_password)
    @OnCheckedChanged(R.id.show_password)
    public void showPassword(boolean checked) {
         mEdtClave.setTransformationMethod(checked ?
                 HideReturnsTransformationMethod.getInstance() :
                 PasswordTransformationMethod.getInstance());

    }


    private void setupinjection() {
        FacePetApplication app = (FacePetApplication) getApplication();
        app.getGraph().inject(this);


    }
}