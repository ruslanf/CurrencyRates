package studio.bz_soft.currencyrates;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import studio.bz_soft.currencyrates.controller.CurrencyAdapter;
import studio.bz_soft.currencyrates.model.Currency;
import studio.bz_soft.currencyrates.model.CurrencyViewModel;
import studio.bz_soft.currencyrates.network.CurrencyInterface;
import studio.bz_soft.currencyrates.network.NetworkModule;
import studio.bz_soft.currencyrates.view.ViewInterface;

public class ListCurrenciesActivity extends AppCompatActivity implements ViewInterface,
        View.OnClickListener, AdapterView.OnItemClickListener {

    private static final String TAG = ListCurrenciesActivity.class.getSimpleName();

    private static final String ASSETS_IMAGE_FOLDER = "icons-48";

    private ListView listViewCurrencies;
    private ProgressBar progressBar;
    private CurrencyAdapter currencyAdapter;

    private CurrencyViewModel createCurrencyViewModel(Currency currency) {
        Bitmap bitmap;
        try {
            String abbreviation = currency.getCurAbbreviation().substring(0, 2);
            String filename = String.format("%s/%s.png", ASSETS_IMAGE_FOLDER, abbreviation);

            InputStream inputStream = getAssets().open(filename);
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException ex) {
            if (BuildConfig.DEBUG) {
                Log.e(TAG, "Assets exception: " + ex);
            }
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable._unknown);
        }
        return new CurrencyViewModel(currency, bitmap);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_currencies);

        listViewCurrencies = findViewById(R.id.listViewCurrencies);
        listViewCurrencies.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        listViewCurrencies.setOnItemClickListener(this);
        currencyAdapter = new CurrencyAdapter(ListCurrenciesActivity.this,
                getApplicationContext(),
                R.layout.row_currencies_layout,
                R.id.textViewAbbreviation,
                R.id.textViewCurrencyName);
        listViewCurrencies.setAdapter(currencyAdapter);

        progressBar = findViewById(R.id.progressBar);
        showWait();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onStart()...");
        }

        CurrencyInterface retrofitApi = NetworkModule.getRetrofit().create(CurrencyInterface.class);

        Observable.fromCallable(retrofitApi::listCurrencies)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .map(data -> data.execute().body())
                .flatMapIterable(item -> item)
                .map(this::createCurrencyViewModel)

//                .toSortedList((item1, item2) -> item1.getCurrency().getCurAbbreviation()
//                        .compareTo(item2.getCurrency().getCurAbbreviation()))

                .sorted((item1, item2) -> item1.getCurrency().getCurAbbreviation()
                        .compareTo(item2.getCurrency().getCurAbbreviation()))

                .subscribe(new DisposableObserver<CurrencyViewModel>() {
                    @Override
                    public void onNext(CurrencyViewModel currencyViewModel) {
                        runOnUiThread(() -> {
                            currencyAdapter.add(currencyViewModel);
                            currencyAdapter.notifyDataSetChanged();
                        });
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (BuildConfig.DEBUG) {
                            Log.e(TAG, "Error - " + e);
                        }
                    }

                    @Override
                    public void onComplete() {
//                        removeWait();
                    }
                });
        removeWait();
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        SparseBooleanArray sparseBooleanArray = listViewCurrencies.getCheckedItemPositions();
        for (int i = 0; i < sparseBooleanArray.size(); i++) {
            int key = sparseBooleanArray.keyAt(i);
            if (sparseBooleanArray.get(key))
                Log.d(TAG, "key: " + key);
        }
    }
}
