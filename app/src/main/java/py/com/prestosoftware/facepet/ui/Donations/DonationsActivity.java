package py.com.prestosoftware.facepet.ui.Donations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import py.com.prestosoftware.facepet.FacePetApplication;
import py.com.prestosoftware.facepet.R;
import py.com.prestosoftware.facepet.data.model.Donaciones;
import py.com.prestosoftware.facepet.ui.main.MainActivity;

public class DonationsActivity extends AppCompatActivity implements DonationContract.DonationView {

    private static final String TAG = DonationsActivity.class.getSimpleName();

    @BindView(R.id.edtUsuario)
    EditText mEdtUsuario;
    @BindView(R.id.edtCelular) EditText mEdtCelular;
    @BindView(R.id.edtDireccionDonante) EditText mEdtDireccion;
    @BindView(R.id.edtObservacion) EditText mEdtObservacion;
    @BindView(R.id.progress_dialogDonation)
    ProgressBar mProgressDialog;
//    @BindView(R.id.imgFoto) ImageView mSetImage;

    @Inject
    DonationContract.DonationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donations);
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

    @OnClick(R.id.btnSolicitarDonacion)
    public void registerDonation(){

        String usuario = mEdtUsuario.getText().toString();
        String celular = mEdtCelular.getText().toString();
        String direccion = mEdtDireccion.getText().toString();
        String obs = mEdtObservacion.getText().toString();

        if(!usuario.isEmpty() && !celular.isEmpty() && !direccion.isEmpty() && !obs.isEmpty()){

            Donaciones donacion = new Donaciones();

            donacion.setNombreUsuario(usuario);
            donacion.setCelular(celular);
            donacion.setDireccion(direccion);
            donacion.setObs(obs);

            presenter.registerDonation(donacion);
        }
    }

    private void setupInjection(){
        FacePetApplication app = (FacePetApplication) getApplication();
        app.getGraph().inject(this);
    }
}
