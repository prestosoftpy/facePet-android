package py.com.prestosoftware.facepet.ui.reservations.Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import py.com.prestosoftware.facepet.FacePetApplication;
import py.com.prestosoftware.facepet.R;
import py.com.prestosoftware.facepet.data.local.FacePetPreference;
import py.com.prestosoftware.facepet.data.model.Reservas;
import py.com.prestosoftware.facepet.ui.main.MainActivity;

public class RegisterReservationsActivity extends AppCompatActivity implements RegisterReservationsContract.ReservationsView {

    private static final String TAG = RegisterReservationsActivity.class.getSimpleName();

    @BindView(R.id.edtFechaReserva)
    EditText mEdtfechareserva;
    @BindView(R.id.spnMascota)
    Spinner mSpnMascota;
    @BindView(R.id.spnCantidad)
    Spinner mSpnCantidad;
    @BindView(R.id.spnServicio)
    Spinner mSpnServicio;
    @BindView(R.id.progress_dialogReservation)
    ProgressBar mProgressDialog;


    @Inject
    RegisterReservationsContract.RerservationsPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations_register);
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
    public void gotoMainActivity() {
        FacePetPreference.setSesion(this);
        startActivity(new Intent(this, MainActivity.class));
    }



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

    @OnClick(R.id.btnConfirmarReserva)
            public void confirmReserve(){

        Date fecha= (Date) mEdtfechareserva.getText();


        Reservas reservita= new Reservas();
        reservita.setFecha(fecha);
        String mascota = mSpnMascota.getSelectedItem().toString(); // Perro,gato
        String cantidad = mSpnCantidad.getSelectedItem().toString();
        String servicio = mSpnServicio.getSelectedItem().toString();
        int mascotaid;
        if(mascota=="Perro"){
             mascotaid=1;
        }else{
            mascotaid=2;
        }
        reservita.setTipo_mascota(mascotaid);//hacer lo mismo para todos los de arriba


        int spinner_pos = mSpnMascota.getSelectedItemPosition();
        String[] size_values = getResources().getStringArray(R.array.mascotas);
        int size = Integer.valueOf(size_values[spinner_pos]); //

    }



    private void setupinjection() {
        FacePetApplication app = (FacePetApplication) getApplication();
        app.getGraph().inject(this);}


}
