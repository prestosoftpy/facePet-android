package py.com.prestosoftware.facepet.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import py.com.prestosoftware.facepet.FacePetApplication;

@Module
public class ApplicationModule {

    private FacePetApplication application;

    public ApplicationModule(FacePetApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return application.getBaseContext();
    }
}
