package studio.bz_soft.currencyrates.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {CurrenciesEntity.class, RatesEntity.class}, version = 1)
public abstract class CurrencyDatabase extends RoomDatabase {

    public abstract CurrenciesDao currenciesDao();

    public static volatile CurrencyDatabase INSTANCE;

    private static final String DB_NAME = "currency_database";

    static CurrencyDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CurrencyDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CurrencyDatabase.class, DB_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
