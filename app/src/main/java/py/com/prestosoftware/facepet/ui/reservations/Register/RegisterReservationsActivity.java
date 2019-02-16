package py.com.prestosoftware.facepet.ui.reservations.Register;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import py.com.prestosoftware.facepet.FacePetApplication;
import py.com.prestosoftware.facepet.R;
import py.com.prestosoftware.facepet.data.local.FacePetPreference;
import py.com.prestosoftware.facepet.data.model.Empresa;
import py.com.prestosoftware.facepet.data.model.Reservas;
import py.com.prestosoftware.facepet.helpers.Util;
import py.com.prestosoftware.facepet.ui.main.MainActivity;
import py.com.prestosoftware.facepet.ui.reservations.List.ReservationListAdapter;

public class RegisterReservationsActivity extends AppCompatActivity implements RegisterReservationsContract.ReservationsView {

    private static final String TAG = RegisterReservationsActivity.class.getSimpleName();
    private Calendar mcalendar;
    private int day, month, year, hour, min;

    @BindView(R.id.edtFechaReserva)
    EditText mEdtfechareserva;
    @BindView(R.id.spnMascota)
    Spinner mSpnMascota;
    @BindView(R.id.spnCantidad)
    Spinner mSpnCantidad;
    @BindView(R.id.spnServicio)
    Spinner mSpnServicio;
    @BindView(R.id.spnEmpresas)
    Spinner mSpnEmpresa;
    @BindView(R.id.progress_dialogReservation)
    ProgressBar mProgressDialog;




    @Inject
    RegisterReservationsContract.RerservationsPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations_register);
        ButterKnife.bind(this);
        setupCalendar();//llamar aqui para que tome la fecha del telefono cuando se abra el activity de registrar Reserva
        setupinjection();
        setupSpinnerEmpresaList();
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


        if(FacePetPreference.getSesion(this)){
            Reservas reservita= new Reservas();
            Log.e(TAG, "holausuario"+ FacePetPreference.getUsuarioID(this));

            String fecha= mEdtfechareserva.getText().toString();
            String mascota= mSpnMascota.getItemAtPosition(mSpnMascota.getSelectedItemPosition()).toString();
            String servicio= mSpnServicio.getItemAtPosition(mSpnServicio.getSelectedItemPosition()).toString();
            int usuarioId= FacePetPreference.getUsuarioID(this);

            int cantidad=1;
            String imagenUrl= "https://www.artmajeur.com/medias/standard/b/a/barandica/artwork/178177_Imagen.jpg";


            int mascotaid;
            if(mascota.equals("Perro") || mascota.equals("Dog")){
                mascotaid=1;
            }else{
                mascotaid=2;
            }

            int servicioid;
            if(servicio.equals("Bathroom") || servicio.equals("Baño") || servicio.equals("Banho")){
                servicioid=1;
            }else{
                if(servicio.equals("Hairdressing") || servicio.equals("Peluqueria") || servicio.equals("cabeleireiro")){
                    servicioid=2;
                }else{
                    servicioid=3;
                }


            }


            reservita.setFecha(Util.formatoFechaAAAAMMDD(new Date(fecha)));
            reservita.setTipoMascota(mascotaid);//hacer lo mismo para todos los de arriba
            reservita.setCantidadMascota(cantidad);
            reservita.setImagenUrl(imagenUrl);
            reservita.setUsuarioId(usuarioId);
            reservita.setServicioId(servicioid);
            reservita.setEmpresaId(((Empresa) mSpnEmpresa.getSelectedItem()).getId());


            Log.d(TAG, reservita.toString());


            presenter.saveReservation(reservita);


            }





       /* int spinner_pos = mSpnMascota.getSelectedItemPosition();
        String[] size_values = getResources().getStringArray(R.array.mascotas);
        int size = Integer.valueOf(size_values[spinner_pos]); //*/
              /* String fecha= mEdtfechareserva.getText().toString();
        Spinner spinnerMascota = (Spinner) findViewById(R.id.spnMascota);
        String mascota = spinnerMascota.getSelectedItem().toString();
        //int cantidad=1;
        Spinner spinnerServicio = (Spinner) findViewById(R.id.spnServicio);
        String servicio = spinnerServicio.getSelectedItem().toString();

        int spinner_pos = mSpnCantidad.getSelectedItemPosition();
        String[] size_values = getResources().getStringArray(R.array.cantidadMascotas);
        int cantidad = Integer.valueOf(size_values[spinner_pos]);*/

        /*String fecha= mEdtfechareserva.getText().toString();
        String mascota = mSpnMascota.getSelectedItem().toString(); // Perro,gato
        Integer cantidad = (Integer) mSpnCantidad.getSelectedItem();
        int cantidad=1;
        String servicio = mSpnServicio.getSelectedItem().toString();*/


        }



    @OnClick(R.id.edtFechaReserva)//sirve para ver como tipo calendario el edt que tiene como tipo de dato datatime
    void openDateDialog() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mEdtfechareserva.setText(new StringBuilder().append(dayOfMonth).append("/")
                        .append(monthOfYear+1).append("/").append(year));
            }
        };

        DatePickerDialog dpDialog = new DatePickerDialog(this, listener, year, month, day);//en un Activity debe ser this, si es un fragment getContex()
        dpDialog.show();
    }

    private void setupCalendar() {
        mcalendar = Calendar.getInstance();
        day = mcalendar.get(Calendar.DAY_OF_MONTH);
        month = mcalendar.get(Calendar.MONTH);
        year = mcalendar.get(Calendar.YEAR);
        hour = mcalendar.get(Calendar.HOUR);
        min = mcalendar.get(Calendar.MINUTE);
    }

    private void setupinjection() {
        FacePetApplication app = (FacePetApplication) getApplication();
        app.getGraph().inject(this);}

        private void setupSpinnerEmpresaList() {
        ArrayAdapter<Empresa> empresasListAdapter = new ArrayAdapter<>(this,
        R.layout.spinner_item, Util.getEmpresas());
        empresasListAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        mSpnEmpresa.setAdapter(empresasListAdapter);
    }

}


