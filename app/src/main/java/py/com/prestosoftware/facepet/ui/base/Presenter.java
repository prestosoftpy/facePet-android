package py.com.prestosoftware.facepet.ui.base;

public interface Presenter<View> {

    void attachView(View t);
    void detachView();

}
