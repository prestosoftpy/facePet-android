package py.com.prestosoftware.facepet.ui.events;

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
import butterknife.OnClick;
import py.com.prestosoftware.facepet.R;
import py.com.prestosoftware.facepet.data.model.Evento;
import py.com.prestosoftware.facepet.helpers.OnClickListener;
import py.com.prestosoftware.facepet.helpers.Util;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    private List<Evento> eventos = new ArrayList<>();
    private static final String TAG = EventsAdapter.class.getSimpleName();
    private OnClickListener listener;

    @Inject
    EventsPresenter presenter;


    public EventsAdapter(List<Evento> eventosList,OnClickListener listener) {
        this.eventos = eventosList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_events, parent, false);
        return new ViewHolder(view);
    }

    public Evento getEvento(int position){
        return eventos.get(position);
    }

    public void setList(List<Evento> eventos){
        this.eventos.clear();
        this.eventos.addAll(eventos);
        notifyDataSetChanged();
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


        holder.bind(eventos.get(position), listener);
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
        @BindView(R.id.ic_favorito) ImageView mImgFav;

        public ViewHolder(View view) {
            super(view);

            ButterKnife.bind(this,view);
        }

        public void bind(final Evento evento, final OnClickListener listener) {
//            mImgFav.setOnClickListener(new View.OnClickListener() {
//                @Override public void onClick(View v) {
//                    listener.onItemClick(evento);
//                }
//            });

            mImgFav.setOnClickListener(c -> listener.onItemClick(evento));
        }


    }


}
