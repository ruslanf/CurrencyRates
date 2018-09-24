package studio.bz_soft.currencyrates.db_model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import studio.bz_soft.currencyrates.BuildConfig;

@Database(entities = {CurrenciesEntity.class, RatesEntity.class}, version = 1)
public abstract class CurrencyDatabase extends RoomDatabase {

    public abstract CurrenciesDao currenciesDao();
    public abstract RatesDao ratesDao();
    private static CurrenciesDao currenciesDao;
    private static RatesDao ratesDao;

    private static CurrencyDatabase INSTANCE;

    private final static String TAG = CurrencyDatabase.class.getSimpleName();

    private static final String DB_NAME = "currency_database";
    private static final MutableLiveData<Boolean> isDataBaseCreated = new MutableLiveData<>();

    public static CurrencyDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CurrencyDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                            CurrencyDatabase.class, DB_NAME)
//                            .allowMainThreadQueries()
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    if (BuildConfig.DEBUG) {
                                        Log.d(TAG, "onCreate from Callback...");
                                    }
                                }

                                @Override
                                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                                    super.onOpen(db);
                                    if (BuildConfig.DEBUG) {
                                        Log.d(TAG, "onOpen from Callback...");
                                    }
                                    if (!context.getDatabasePath(DB_NAME).exists()) {
                                        if (BuildConfig.DEBUG) {
                                            Log.d(TAG, "DB not exists...");
                                        }
                                    } else {
                                        if (BuildConfig.DEBUG) {
                                            Log.d(TAG, "DB exists...");
                                        }
                                    }
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private static void populateDB() {

        CurrenciesEntity currenciesEntity = new CurrenciesEntity(0, 0, 0,
                "", "", "");
        currenciesDao.insert(currenciesEntity);

        RatesEntity ratesEntity = new RatesEntity(0, 0, "",
                "", "", "", 0);
        ratesDao.insert(ratesEntity);
    }

}
