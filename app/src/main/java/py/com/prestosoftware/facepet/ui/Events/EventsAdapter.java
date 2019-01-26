package py.com.prestosoftware.facepet.ui.Events;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import py.com.prestosoftware.facepet.R;
import py.com.prestosoftware.facepet.data.model.Eventos;
import py.com.prestosoftware.facepet.helpers.Util;

import java.util.List;


public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    private List<Eventos> eventos;
    private static final String TAG = EventsAdapter.class.getSimpleName();

    public EventsAdapter(List<Eventos> eventosList) {
        this.eventos = eventosList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_events, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        String nombre = eventos.get(position).getUsuario().getNombre();
        Log.d(TAG, "ObjUsuario = "+nombre);
        String iniciales = nombre.substring(0,1)+nombre.substring(nombre.indexOf(" ")+1,nombre.indexOf(" ")+2);
        Log.d(TAG, "iniciales = "+iniciales);
        //String iniciales = "NE";
        holder.mTxtUsuario.setText(iniciales.toUpperCase());
        holder.mTxtNombre.setText(eventos.get(position).getNombre());
        holder.mTxtFchEvento.setText(Util.formatoFechaDDMMAAAA(eventos.get(position).getFecha()));
        Picasso.get().load(eventos.get(position).getImagenUrl())
                .fit()
                .into(holder.mImgEvento);
        holder.mTxtDescripcion.setText(eventos.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_usuario) TextView mTxtUsuario;
        @BindView(R.id.txt_nombre) TextView mTxtNombre;
        @BindView(R.id.txt_fch_evento) TextView mTxtFchEvento;
        @BindView(R.id.img_event) ImageView mImgEvento;
        @BindView(R.id.txt_descripcion) TextView mTxtDescripcion;


        public ViewHolder(View view) {
            super(view);

            ButterKnife.bind(this,view);
        }



    }
}
