package studio.bz_soft.currencyrates.db_model;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;
import android.util.Log;

import studio.bz_soft.currencyrates.BuildConfig;

@Database(entities = {CurrenciesEntity.class, RatesEntity.class}, version = 1, exportSchema = false)
public abstract class CurrencyDatabase extends RoomDatabase {

    public abstract CurrenciesDao currenciesDao();
    public abstract RatesDao ratesDao();

    private final static String TAG = CurrencyDatabase.class.getSimpleName();

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "createInvalidationTracker()...");
        }
        return null;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "createOpenHelper()...");
        }
        return null;
    }
}
