package py.com.prestosoftware.facepet.ui.petshop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import py.com.prestosoftware.facepet.FacePetApplication;
import py.com.prestosoftware.facepet.R;
import py.com.prestosoftware.facepet.data.model.Empresa;
import py.com.prestosoftware.facepet.ui.petshop.dummy.PetShopContract;

/***
 * @author nestorcde
 * @version 0.01
 */
public class PetShopFragment extends Fragment implements PetShopContract.PetShopView {
    @BindView(R.id.empresaRecyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.progress_indicator) ProgressBar mProgressBar;

    @Inject PetShopPresenter presenter;

    private static final String TAG = PetShopFragment.class.getSimpleName();

    private static PetShopFragment fragment;
    public PetShopFragment() {
    }

    public static PetShopFragment newInstance(){
        if(fragment==null) {
            fragment = new PetShopFragment();
        }
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_petshop_list, container, false);

        ButterKnife.bind(this,view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setupInjection();
        presenter.attachView(this);
        presenter.getEmpresas();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    private void setupInjection(){
        FacePetApplication app = (FacePetApplication) getActivity().getApplication();
        app.getGraph().inject(this);
    }

    @Override
    public void loadEmpresas(List<Empresa> empresas) {
        mRecyclerView.setAdapter(new PetShopAdapter(empresas));
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onEntityError(String error) {
        Log.d(TAG,error);
    }
}
