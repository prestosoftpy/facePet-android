package py.com.prestosoftware.facepet.ui.cities;

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
import py.com.prestosoftware.facepet.data.model.Ciudades;


import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private final List<Ciudades> ciudades;


    //constructor de la clase, context se encarga de metodos utiles para utilizar los recursos del celular
    public CityAdapter(List<Ciudades> ciudadesList){
        this.ciudades= ciudadesList;
    }

    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_city, parent, false);
        return new CityAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityAdapter.ViewHolder holder, int position) {
        holder.mNombre.setText(ciudades.get(position).getDescripcion());
        holder.mDescripcion.setText(ciudades.get(position).getAbreviatura());

        Picasso.get().load(ciudades.get(position).getImagen_url())//Trae la imagen de internet
                .centerCrop().fit()//centra la imagen
                .into(holder.imgciudad);//Carga en imgempresa

    }

    @Override
    public int getItemCount() {
        return ciudades.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //public final View mView;
        //public DummyItem mItem; se usaba anteriormente pero le adaptamos
        @BindView(R.id.img_ciudad)
        ImageView imgciudad;
        @BindView(R.id.txtciudadnombre) TextView mNombre;
        @BindView(R.id.txtciudaddescripcion) TextView mDescripcion;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);// es lo mismo que this.nombreCiudad= nombreCiudad por ejemplo ,es del constructor

        }


    }
}
