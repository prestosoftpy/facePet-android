package py.com.prestosoftware.facepet.ui.reservas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import py.com.prestosoftware.facepet.FacePetApplication;
import py.com.prestosoftware.facepet.R;

public class ReservationsActivity extends AppCompatActivity implements ReservationsContract.ReservationsView{

    private static final String TAG = ReservationsActivity.class.getSimpleName();

    @BindView(R.id.edtfecha_reserva)
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
    ReservationsContract.RerservationsPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);
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

    private void setupinjection() {
        FacePetApplication app = (FacePetApplication) getApplication();
        app.getGraph().inject(this);}


}
