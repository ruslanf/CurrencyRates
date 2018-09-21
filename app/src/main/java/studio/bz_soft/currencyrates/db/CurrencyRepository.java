package studio.bz_soft.currencyrates.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;

import studio.bz_soft.currencyrates.model.Currency;
import studio.bz_soft.currencyrates.model.Rate;

public class CurrencyRepository {

    private CurrenciesDao currenciesDao;
    private RatesDao ratesDao;
    private LiveData<List<Currency>> allCurrencies;
    private LiveData<List<Rate>> allRates;

    public CurrencyRepository(Application application) {
        CurrencyDatabase currencyDatabase = CurrencyDatabase.getDatabase(application);
        currenciesDao = currencyDatabase.currenciesDao();
        allCurrencies = (LiveData<List<Currency>>) currenciesDao.getAllFromCurrencies();
        ratesDao = currencyDatabase.ratesDao();
        allRates = (LiveData<List<Rate>>) ratesDao.getAllFromRates();
    }

    LiveData<List<Currency>> getAllCurrencies() {
        return allCurrencies;
    }

    LiveData<List<Rate>> getAllRates() {
        return allRates;
    }

    public void insertCurrencies(Currency currency) {
        new InsertCurrencyAsyncTask(currenciesDao).doInBackground(currency);
    }

    public void insertRates(Rate rate) {
        new InsertRatesAsyncTask(ratesDao).doInBackground(rate);
    }
}
