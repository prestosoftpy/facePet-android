package py.com.prestosoftware.facepet.ui.Petshop;

import android.content.Context;
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
import py.com.prestosoftware.facepet.data.model.Empresa;

import java.util.List;


public class PetShopAdapter extends RecyclerView.Adapter<PetShopAdapter.ViewHolder> {

    private final List<Empresa> empresas;


    //private final OnListFragmentInteractionListener mListener;

    /*public PetShopAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        empresas = items;
        mListener = listener;
    }*/

    //constructor de la clase, context se encarga de metodos utiles para utilizar los recursos del celular
    public PetShopAdapter(List<Empresa> empresaList){
        this.empresas= empresaList;
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
        holder.mNombre.setText(empresas.get(position).getNombre());
        holder.mDireccion.setText(empresas.get(position).getDireccion());

        Picasso.get().load(empresas.get(position).getImagen_url())//Trae la imagen de internet
                .centerCrop().fit()//centra la imagen
                .into(holder.imgempresa);//Carga en imgempresa

       /* holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return empresas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //public final View mView;
        //public DummyItem mItem; se usaba anteriormente pero le adaptamos
        @BindView(R.id.img_empresa) ImageView imgempresa;
        @BindView(R.id.txtempresanombre) TextView mNombre;
        @BindView(R.id.txtempresadireccion) TextView mDireccion;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);// es lo mismo que this.empresa= empresa por ejemplo ,es del constructor

        }


    }
}
