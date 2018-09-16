package studio.bz_soft.currencyrates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import rx.schedulers.Schedulers;
import studio.bz_soft.currencyrates.network.NetworkModule;
import studio.bz_soft.currencyrates.network.CurrencyInterface;
import studio.bz_soft.currencyrates.view.ViewInterface;

public class ListCurrenciesActivity extends AppCompatActivity implements ViewInterface {

    private static final String TAG = ListCurrenciesActivity.class.getSimpleName();

    private ListView listViewCurrencies;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_currencies);

        listViewCurrencies = findViewById(R.id.listViewCurrencies);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onStart()...");
        }

//        RxJavaCallAdapterFactory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.createWithScheduler(rx.schedulers.Schedulers.io());
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://www.nbrb.by/API/ExRates/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(rxJavaCallAdapterFactory)
//                .build();
//
//        CurrencyInterface currencyInterface = retrofit.create(CurrencyInterface.class);

//        Observable<List<Currency>> observable = currencyInterface.listCurrencies();
//        observable.subscribeOn(Schedulers.io()).subscribe();

        CurrencyInterface retrofitApi = NetworkModule.getRetrofit().create(CurrencyInterface.class);
        retrofitApi.listCurrencies()
                .subscribeOn(Schedulers.io())
                .subscribe();

//        currencyInterface.listCurrencies().enqueue(new Callback<List<Currency>>() {
//            @Override
//            public void onResponse(Call<List<Currency>> call, Response<List<Currency>> response) {
//                CurrencyAdapter currencyAdapter = new CurrencyAdapter(ListCurrenciesActivity.this,
//                        getApplicationContext(),
//                        R.layout.row_currencies_layout,
//                        R.id.textViewAbbreviation,
//                        R.id.textViewCurrencyName,
//                        response.body());
//                listViewCurrencies.setAdapter(currencyAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<Currency>> call, Throwable t) {
//
//            }
//        });
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }
}
