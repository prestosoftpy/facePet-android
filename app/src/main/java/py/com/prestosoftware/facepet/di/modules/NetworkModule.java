package py.com.prestosoftware.facepet.di.modules;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import py.com.prestosoftware.facepet.BuildConfig;
import py.com.prestosoftware.facepet.FacePetApplication;
import py.com.prestosoftware.facepet.data.remote.FacePetService;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public String provideApiUrl() {
        return FacePetApplication.API_URL;
    }

    //login Interceptor
    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoginInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        return BuildConfig.DEBUG ? interceptor.setLevel(HttpLoggingInterceptor.Level.BODY) :
                interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
    }

    //OkHttp Factory
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
    }

    //Converter Factory
    @Provides
    @Singleton
    Converter.Factory provideConverterFactory() {
        return GsonConverterFactory.create();
    }

    //Retrofit Factory
    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client, Converter.Factory converter) { //String url,
        return new Retrofit.Builder()
                .baseUrl(provideApiUrl())
                .client(client)
                .addConverterFactory(converter)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    //API Client
    @Provides
    @Singleton
    FacePetService provideApiClient(Retrofit retrofit) {
        return retrofit.create(FacePetService.class);
    }
}
