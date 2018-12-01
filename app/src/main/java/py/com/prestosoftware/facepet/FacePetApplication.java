package py.com.prestosoftware.facepet;

import android.app.Application;

public class FacePetApplication extends Application {

    public static final String API_URL = "http://35.227.62.251:3000/api/v1/";

    @Override
    public void onCreate() {
        super.onCreate();

        // crashlitycs - > Twitter Crashlitycs
        // firebase Cloud Messaging -> FCM
        // Base de Datos Local -> Realm.io
    }
}
