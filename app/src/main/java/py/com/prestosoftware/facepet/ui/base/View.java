package py.com.prestosoftware.facepet.ui.base;

public interface View {
    void showProgress();
    void hideProgress();
    void onEntityError(String error);
}
