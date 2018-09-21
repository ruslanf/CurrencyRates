package studio.bz_soft.currencyrates.db;

import android.os.AsyncTask;

import studio.bz_soft.currencyrates.model.Currency;

public class InsertCurrencyAsyncTask extends AsyncTask<Currency, Void, Void> {

    private CurrenciesDao asyncTaskCurrenciesDao;

    public InsertCurrencyAsyncTask(CurrenciesDao asyncTaskCurrenciesDao) {
        this.asyncTaskCurrenciesDao = asyncTaskCurrenciesDao;
    }

    @Override
    protected Void doInBackground(final Currency... currency) {
        asyncTaskCurrenciesDao.insert(currency[0]);
        return null;
    }
}
