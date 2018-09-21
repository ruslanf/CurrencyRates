package studio.bz_soft.currencyrates.db;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import studio.bz_soft.currencyrates.model.Currency;

public class CurrenciesViewModel extends AndroidViewModel {

    private CurrencyRepository currencyRepository;
    private LiveData<List<Currency>> allCurrencies;

    public CurrenciesViewModel(@NonNull Application application) {
        super(application);
        currencyRepository = new CurrencyRepository(application);
        allCurrencies = currencyRepository.getAllCurrencies();
    }

    public void insert(Currency currency) {
        currencyRepository.insertCurrencies(currency);
    }

    public LiveData<List<Currency>> getAllCurrencies() {
        return allCurrencies;
    }
}
