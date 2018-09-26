package studio.bz_soft.currencyrates.db;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import studio.bz_soft.currencyrates.db_model.App;
import studio.bz_soft.currencyrates.db_model.CurrenciesDao;
import studio.bz_soft.currencyrates.db_model.CurrenciesEntity;
import studio.bz_soft.currencyrates.db_model.CurrencyDatabase;

public class CurrenciesViewModel extends AndroidViewModel {

    private static final String TAG = CurrenciesViewModel.class.getSimpleName();

    private CurrenciesDao currenciesDao;
    private LiveData<List<CurrenciesEntity>> allCurrencies;

    public CurrenciesViewModel(@NonNull Application application) {
        super(application);
        CurrencyDatabase currencyDatabase = App.getInstance().getDatabaseInstance();

        Observable
                .fromCallable(() -> currenciesDao = currencyDatabase.currenciesDao())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(currencies -> {
                    allCurrencies = currencyDatabase.currenciesDao().getAllFromCurrencies();
                    Log.d(TAG, "allCurrencies...");
                    return allCurrencies;
                })
                .onErrorReturn(throwable -> {
                    Log.e(TAG, "Error...");
                    return null;})
                .subscribe();
    }

    public LiveData<List<CurrenciesEntity>> getAllCurrenciesList() {
        return allCurrencies;
    }

    public void insert(CurrenciesEntity currenciesEntity) {
        currenciesDao.insert(currenciesEntity);
    }
}
