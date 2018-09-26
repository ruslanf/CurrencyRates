package studio.bz_soft.currencyrates.db_model;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;
import android.util.Log;

import studio.bz_soft.currencyrates.BuildConfig;

public class App extends Application {

    private static final String TAG = App.class.getSimpleName();

    private static App INSTANCE;
    private CurrencyDatabase currencyDatabase;

    public App() {
    }

    public static App getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        currencyDatabase = Room.databaseBuilder(getApplicationContext(),
                CurrencyDatabase.class, Const.DB_NAME)
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        if (BuildConfig.DEBUG) {
                            Log.d(TAG, "onCreate from Callback...");
                        }
                        db.execSQL(Const.CREATE_TABLE_CURRENCIES);
                        db.execSQL(Const.CREATE_TABLE_RATES);
                    }

                    @Override
                    public void onOpen(@NonNull SupportSQLiteDatabase db) {
                        super.onOpen(db);
                        if (BuildConfig.DEBUG) {
                            Log.d(TAG, "onOpen from Callback...");
                        }
                        if (!getDatabasePath(Const.DB_NAME).exists()) {
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

    public CurrencyDatabase getDatabaseInstance() {
        return currencyDatabase;
    }
}
