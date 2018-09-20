package studio.bz_soft.currencyrates.network;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

public class NetworkModule {

    private static final String BASE_API_URL = "http://www.nbrb.by/API/ExRates/";

    private static InternetConnectionListener internetConnectionListener;

    private static Retrofit retrofit = null;
    private static Application app;

    public NetworkModule(Application application) {
        this.app = application;
    }

    public static Retrofit getRetrofit() {

        RxJavaCallAdapterFactory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory
                .createWithScheduler(Schedulers.io());

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_API_URL)
                    .client(okHttpClient())
                    .build();
        }
        return retrofit;
    }

    public void setInternetConnectionListener(InternetConnectionListener listener) {
        internetConnectionListener = listener;
    }

    public void removeInternetConnectionListener() {
        internetConnectionListener = null;
    }

    private static OkHttpClient okHttpClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(30, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS);

        okHttpClientBuilder.addInterceptor(new NetworkModuleInterceptor() {

            @Override
            public boolean isInternetAvailable() {
                boolean result = false;
                try {
                    ConnectivityManager connectivityManager =
                            (ConnectivityManager) app.getApplicationContext()
                                    .getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                        result = true;
                    }
                } catch (Exception ex) {
                    result = false;
                }
                return result;
//                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            }

            @Override
            public void onInternetUnavailable() {
                if (internetConnectionListener != null) {
                    internetConnectionListener.onInternetUnavailable();
                }
            }
        });

        return okHttpClientBuilder.build();
    }
}
