package studio.bz_soft.currencyrates;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import studio.bz_soft.currencyrates.controller.CurrencyAdapter;
import studio.bz_soft.currencyrates.model.Currency;
import studio.bz_soft.currencyrates.model.Image;
import studio.bz_soft.currencyrates.model.ImageList;
import studio.bz_soft.currencyrates.network.NetworkModule;
import studio.bz_soft.currencyrates.network.CurrencyInterface;
import studio.bz_soft.currencyrates.view.ViewInterface;

public class ListCurrenciesActivity extends AppCompatActivity implements ViewInterface {

    private static final String TAG = ListCurrenciesActivity.class.getSimpleName();

    private static final String ASSETS_IMAGE_FOLDER = "icons-48";

    private ListView listViewCurrencies;
    private ProgressBar progressBar;
    private CompositeDisposable compositeDisposable;

    private ImageList imageList;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_currencies);

        listViewCurrencies = findViewById(R.id.listViewCurrencies);
        progressBar = findViewById(R.id.progressBar);
        showWait();

        Observable<List<Image>> observableImageList = Observable.fromCallable(new Callable<List<Image>>() {
            @Override
            public List<Image> call() throws Exception {
                List<Image> list = new ArrayList<>();

                String[] imageFolder = getAssets().list(ASSETS_IMAGE_FOLDER);
                if (imageFolder.length > 0) {
                    for (int i = 0; i < imageFolder.length; i++) {
                        String filename = String.format("%s/%s", ASSETS_IMAGE_FOLDER, imageFolder[i]);
                        String code = imageFolder[i].substring(0, 2);
                        InputStream inputStream = getAssets().open(filename);
                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                        list.add(new Image(code, bitmap));
                    }
                } else {
                    if (BuildConfig.DEBUG) {
                        Log.d(TAG, "No images in asset folder...");
                    }
                }
                return list;
            }
        });
        Disposable disposable =
        observableImageList
                .subscribeOn(Schedulers.io())
                .subscribe(list -> imageList = new ImageList(list));

        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onStart()...");
        }

        CurrencyInterface retrofitApi = NetworkModule.getRetrofit().create(CurrencyInterface.class);
        retrofitApi.listCurrencies()
                .enqueue(new Callback<List<Currency>>() {
                    @Override
                    public void onResponse(Call<List<Currency>> call, Response<List<Currency>> response) {
                        if (response.body() != null) {
                            CurrencyAdapter currencyAdapter = new CurrencyAdapter(ListCurrenciesActivity.this,
                                    getApplicationContext(),
                                    R.layout.row_currencies_layout,
                                    R.id.textViewAbbreviation,
                                    R.id.textViewCurrencyName,
                                    response.body(), imageList);
                            listViewCurrencies.setAdapter(currencyAdapter);
                        }
                        removeWait();
                    }

                    @Override
                    public void onFailure(Call<List<Currency>> call, Throwable t) {

                    }
                });
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
