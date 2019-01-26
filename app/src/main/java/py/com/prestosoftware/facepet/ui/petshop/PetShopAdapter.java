package py.com.prestosoftware.facepet.ui.petshop;

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
import py.com.prestosoftware.facepet.ui.petshop.dummy.DummyContent.DummyItem;

import java.util.List;

public class PetShopAdapter extends RecyclerView.Adapter<PetShopAdapter.ViewHolder> {

    private List<Empresa> empresas;

    //Constructor de la Clase
    public PetShopAdapter(List<Empresa> empresaList){
        this.empresas = empresaList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_petshop, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.mNombre.setText(empresas.get(position).getNombre());
        holder.mDireccion.setText(empresas.get(position).getDireccion());

        Picasso.get().load(empresas.get(position).getImagenUrl())
                //.centerCrop()
                .fit()
                .into(holder.imgEmpresa);
        //Alternativas a Picasso
        //fresco - Facebook
        //glide - Bumptech
    }

    @Override
    public int getItemCount() {
        return empresas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_empresa) ImageView imgEmpresa;
        @BindView(R.id.txt_empresa_nombre) TextView mNombre;
        @BindView(R.id.txt_empresa_direccion) TextView mDireccion;

        public ViewHolder(View view) {
            super(view);

            ButterKnife.bind(this,view);
        }
    }
}
