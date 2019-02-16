package py.com.prestosoftware.facepet.ui.cities;

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
import py.com.prestosoftware.facepet.data.model.Ciudades;

public class CityFragment extends Fragment implements  CityContract.CiudadesView {

    private static final String TAG= CityFragment.class.getSimpleName();

    @BindView(R.id.ciudadesRecyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.progress_indicator)
    ProgressBar mProgressBar;

    @Inject
    CityPresenter presenter;

    private static CityFragment fragment;

    public CityFragment() {
    }

    public static CityFragment newInstance() {
        if (fragment == null) {
            fragment = new CityFragment();
        }
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city_list, container, false);

        ButterKnife.bind(this, view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setupInjection();
        presenter.attachView(this);
        presenter.getCiudades();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }




    @Override
    public void loadCiudades(List<Ciudades> ciudades) {
        mRecyclerView.setAdapter(new CityAdapter(ciudades));
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

    private void setupInjection(){
        FacePetApplication app = (FacePetApplication) getActivity().getApplication();
        app.getGraph().inject(this);

    }
}
