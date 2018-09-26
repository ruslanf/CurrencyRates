package studio.bz_soft.currencyrates.db_model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CurrenciesDao {

    @Query("SELECT * FROM Currencies")
    LiveData<List<CurrenciesEntity>> getAllFromCurrencies();

    @Insert
    void insert(CurrenciesEntity currenciesEntity);

    @Delete
    void deleteAll(CurrenciesEntity currenciesEntity);
}
