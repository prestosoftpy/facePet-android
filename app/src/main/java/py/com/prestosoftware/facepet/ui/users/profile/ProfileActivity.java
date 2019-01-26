package py.com.prestosoftware.facepet.ui.users.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import py.com.prestosoftware.facepet.FacePetApplication;
import py.com.prestosoftware.facepet.R;
import py.com.prestosoftware.facepet.data.model.Token;
import py.com.prestosoftware.facepet.data.model.Usuario;
import py.com.prestosoftware.facepet.ui.users.login.LoginActivity;
import py.com.prestosoftware.facepet.ui.users.login.LoginContract;
import py.com.prestosoftware.facepet.ui.users.register.RegisterActivity;
import py.com.prestosoftware.facepet.ui.users.register.RegisterContract;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.ProfileView {
    private final String TAG = ProfileActivity.class.getSimpleName();

    @BindView(R.id.txtNombreProfile) TextView txtNombre;
    //@BindView(R.id.txtApellidoProfile) TextView txtApellido;
    @BindView(R.id.txtEmail) TextView txtEmail;
    @BindView(R.id.txtTelefono) TextView txtTelefono;
    @BindView(R.id.txtCiudad) TextView txtCiudad;
    @BindView(R.id.txtDireccion) TextView txtDireccion;
    @BindView(R.id.progress_dialogProfile) ProgressBar mProgressDialog;

    @Inject
    ProfileContract.ProfilePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        setupInjection();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView(this);
        presenter.UserData(1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }




    @Override
    public void showProgress() {
        mProgressDialog.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        mProgressDialog.setVisibility(View.GONE);

    }

    @Override
    public void onEntityError(String error) {

    }


    public void UserData(){




    }


    private void setupInjection(){
        FacePetApplication app = (FacePetApplication) getApplication();
        app.getGraph().inject(this);
    }


    @Override
    public void getProfile(Usuario usuario) {
        //Log.d(TAG,usuario.toString());
        if(usuario!= null) {

            txtNombre.setText(usuario.getNombre());
            //txtApellido.setText(usuario.getApellido());
            txtEmail.setText(usuario.getEmail());
            txtTelefono.setText(usuario.getCelular());
            txtCiudad.setText(usuario.getCiudad_id());
            txtEmail.setText(usuario.getEmail());
            txtDireccion.setText(usuario.getDireccion());
            Log.d(TAG,usuario.toString());


        }

    }
}
