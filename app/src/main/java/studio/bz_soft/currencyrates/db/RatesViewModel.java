package studio.bz_soft.currencyrates.db;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import studio.bz_soft.currencyrates.db_model.App;
import studio.bz_soft.currencyrates.db_model.CurrencyDatabase;
import studio.bz_soft.currencyrates.db_model.RatesDao;
import studio.bz_soft.currencyrates.db_model.RatesEntity;

public class RatesViewModel extends AndroidViewModel {

    private static final String TAG = RatesViewModel.class.getSimpleName();

    private RatesDao ratesDao;
    private LiveData<List<RatesEntity>> allRates;

    public RatesViewModel(Application application) {
        super(application);
        CurrencyDatabase currencyDatabase = App.getInstance().getDatabaseInstance();
        Observable
                .fromCallable(() -> ratesDao = currencyDatabase.ratesDao())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(rates -> {
                    allRates = currencyDatabase.ratesDao().getAllFromRates();
                    Log.d(TAG, "allRates...");
                    return allRates;
                })
                .onErrorReturn(throwable -> {
                    Log.e(TAG, "Error...");
                    return null;})
                .subscribe();
//        ratesDao = CurrencyDatabase.getDatabase(application).ratesDao();
//        allRates = (LiveData<List<RatesEntity>>) ratesDao.getAllFromRates();
    }

    public LiveData<List<RatesEntity>> getAllRates() {
        return allRates;
    }

    public void insert(RatesEntity ratesEntity) {
        ratesDao.insert(ratesEntity);
    }
}
