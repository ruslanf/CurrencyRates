package studio.bz_soft.currencyrates.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

public class NetworkModule {

    private static final String BASE_API_URL = "http://www.nbrb.by/API/ExRates/";

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {

        RxJavaCallAdapterFactory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_API_URL)
                    .build();
        }
        return retrofit;
    }
}
