package py.com.prestosoftware.facepet.ui.Events;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import py.com.prestosoftware.facepet.FacePetApplication;
import py.com.prestosoftware.facepet.R;
import py.com.prestosoftware.facepet.data.model.Eventos;
import py.com.prestosoftware.facepet.ui.Events.dummy.EventsContract;

import java.util.List;

import javax.inject.Inject;

/**
 * @author nestorcde
 * @version 0.01
 */
public class EventsFragment extends Fragment implements EventsContract.EventsView {
    @BindView(R.id.eventsRecyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.progress_indicator) ProgressBar mProgressBar;

    @Inject
    EventsPresenter presenter;

    private static final String TAG = EventsFragment.class.getSimpleName();

    private static EventsFragment fragment;
    public EventsFragment() {
    }
    // Sigleton
    public static EventsFragment newInstance() {
        if(fragment==null){
            fragment = new EventsFragment();
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_list, container, false);

        ButterKnife.bind(this,view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setupInjection();
        presenter.attachView(this);
        presenter.getEvents();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();

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

    @Override
    public void loadEvents(List<Eventos> eventos) {
        mRecyclerView.setAdapter(new EventsAdapter(eventos));
    }

    private void setupInjection(){
        FacePetApplication app = (FacePetApplication) getActivity().getApplication();
        app.getGraph().inject(this);
    }
}
