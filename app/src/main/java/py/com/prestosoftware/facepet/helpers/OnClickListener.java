package py.com.prestosoftware.facepet.helpers;

import android.view.View;

import py.com.prestosoftware.facepet.data.model.Evento;

public interface OnClickListener {
    void onItemClick(Evento evento);
    void localizClick(Evento evento);
}
