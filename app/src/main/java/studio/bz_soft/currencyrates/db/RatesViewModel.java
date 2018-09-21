package studio.bz_soft.currencyrates.db;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import studio.bz_soft.currencyrates.model.Rate;

public class RatesViewModel extends AndroidViewModel {

    private CurrencyRepository currencyRepository;
    private LiveData<List<Rate>> allRates;

    public RatesViewModel(@NonNull Application application) {
        super(application);
        currencyRepository = new CurrencyRepository(application);
        allRates = currencyRepository.getAllRates();
    }

    public LiveData<List<Rate>> getAllRates() {
        return allRates;
    }

    public void insert(Rate rate) {
        currencyRepository.insertRates(rate);
    }
}
