package py.com.prestosoftware.facepet.ui.reservations.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import py.com.prestosoftware.facepet.R;
import py.com.prestosoftware.facepet.data.model.Reservas;

import java.util.List;

public class ReservationListAdapter extends RecyclerView.Adapter<ReservationListAdapter.ViewHolder> {

    private final List<Reservas> reservas;



    public ReservationListAdapter(List<Reservas> reservasList){
        this.reservas= reservasList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_petshop, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.mItem = empresas.get(position);
        holder.mFechaReserva.setText((CharSequence) reservas.get(position).getFecha());
        holder.mEstadoReserva.setText(reservas.get(position).getEstado_reserva());

        Picasso.get().load(reservas.get(position).getEmpresa_id().getImagen_url())//Trae la imagen de internet
                .centerCrop().fit()//centra la imagen
                .into(holder.imgReserva);//Carga en imgempresa

    }

    @Override
    public int getItemCount() {
        return reservas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_empresaReservaList)
        ImageView imgReserva;
        @BindView(R.id.txtFechaReservaList) TextView mFechaReserva;
        @BindView(R.id.txtEstadoReserva) TextView mEstadoReserva;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);// es lo mismo que this.empresa= empresa por ejemplo ,es del constructor

        }


    }
}
