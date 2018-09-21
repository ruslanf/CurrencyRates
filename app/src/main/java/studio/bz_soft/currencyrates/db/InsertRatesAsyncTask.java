package studio.bz_soft.currencyrates.db;

import android.os.AsyncTask;

import studio.bz_soft.currencyrates.model.Rate;

public class InsertRatesAsyncTask extends AsyncTask<Rate, Void, Void> {

    private RatesDao asyncTaskRatesDao;

    public InsertRatesAsyncTask(RatesDao asyncTaskRatesDao) {
        this.asyncTaskRatesDao = asyncTaskRatesDao;
    }

    @Override
    protected Void doInBackground(final Rate... rates) {
        return null;
    }
}
