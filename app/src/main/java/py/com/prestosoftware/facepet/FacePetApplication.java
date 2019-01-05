package py.com.prestosoftware.facepet;

import android.app.Application;
import py.com.prestosoftware.facepet.di.components.ApplicationComponent;
import py.com.prestosoftware.facepet.di.components.DaggerApplicationComponent;
import py.com.prestosoftware.facepet.di.modules.ApplicationModule;
import py.com.prestosoftware.facepet.di.modules.NetworkModule;
import py.com.prestosoftware.facepet.di.modules.UserModule;

public class FacePetApplication extends Application {

    public static final String API_URL = "http://35.227.62.251:3000/api/v1/";

    private ApplicationComponent graph;

    @Override
    public void onCreate() {
        super.onCreate();
        initDependencyGraph();
        // crashlitycs - > Twitter Crashlitycs
        // firebase Cloud Messaging -> FCM
        // Base de Datos Local -> Realm.io
    }

    private void initDependencyGraph() {
        graph = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .userModule(new UserModule())
                .build();

        graph.inject(this);
    }

    public ApplicationComponent getGraph() {
        return graph;
    }

}
