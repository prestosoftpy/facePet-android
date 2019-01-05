package py.com.prestosoftware.facepet.ui.users.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import py.com.prestosoftware.facepet.FacePetApplication;
import py.com.prestosoftware.facepet.R;
import py.com.prestosoftware.facepet.data.model.Usuario;
import py.com.prestosoftware.facepet.ui.main.MainActivity;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.RegisterView{

    private static final String TAG = RegisterActivity.class.getSimpleName();

    @BindView(R.id.edtEmail) EditText mEdtEmail;
    @BindView(R.id.edtNombre) EditText mEdtNombre;
    @BindView(R.id.edtPassword) EditText mEdtPassword;
    @BindView(R.id.edtApellidok) EditText mEdtApellido;
    @BindView(R.id.edtTelefono) EditText mEdtTelefono;
    @BindView(R.id.edtCiudadId) EditText mEdtCiudadId;
    @BindView(R.id.edtDireccion) EditText mEdtDireccion;
    @BindView(R.id.progress_dialog) ProgressBar mProgressDialog;
//    @BindView(R.id.imgFoto) ImageView mSetImage;

    @Inject RegisterContract.RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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
    public void goToMainActivity() {
        startActivity( new Intent(this,MainActivity.class));
    }




    @Override
    public void goToProfileActivity() {
        //startActivity( new Intent(this,ProfileActivity.class));
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

    @OnClick(R.id.btnRegistrar)
    public void registerUser(){

        String email = mEdtEmail.getText().toString();
        String nombre = mEdtNombre.getText().toString();
        String apellido = mEdtApellido.getText().toString();
        String telefono = mEdtTelefono.getText().toString();
        String direccion = mEdtDireccion.getText().toString();
        String password = mEdtPassword.getText().toString();
        int ciudad_id = Integer.valueOf(mEdtCiudadId.getText().toString());

        if(!email.isEmpty() && !nombre.isEmpty() && !password.isEmpty() && !apellido.isEmpty() && !telefono.isEmpty() && !direccion.isEmpty() ){
//            Log.d(TAG, email);
//            Log.d(TAG, nombre);
//            Log.d(TAG, password);

            Usuario usuario = new Usuario();

            usuario.setEmail(email);
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setCelular(telefono);
            usuario.setCiudad_id(ciudad_id);
            usuario.setDireccion(direccion);
            usuario.setClave(password);

            presenter.registerUser(usuario);
        }
    }

    private void setupInjection(){
        FacePetApplication app = (FacePetApplication) getApplication();
        app.getGraph().inject(this);
    }


}

