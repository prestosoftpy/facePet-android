package py.com.prestosoftware.facepet.ui.reservations.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import py.com.prestosoftware.facepet.data.model.Reservas;


public class ReservationListFragment extends Fragment implements ReservationListContract.ReservationsView{

    private static final String TAG= ReservationListFragment.class.getSimpleName();

    @BindView(R.id.reservaRecyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.progress_indicator)
    ProgressBar mProgressBar;

    @Inject
    ReservationListPresenter presenter;

    private static ReservationListFragment fragment;

    public ReservationListFragment() {
    }

    public static ReservationListFragment newInstance() {
        if (fragment == null) {// para que no instancie cada vez que se carga la pantalla
            fragment = new ReservationListFragment();
        }
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservations_list, container, false);

        ButterKnife.bind(this, view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setupInjection();
        presenter.attachView(this);
        presenter.getReservas();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }





    @Override
    public void loadReservas(List<Reservas> reservas) {
        mRecyclerView.setAdapter(new ReservationListAdapter(reservas));
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
