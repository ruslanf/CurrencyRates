package studio.bz_soft.currencyrates.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CurrenciesDao {

    @Query("SELECT * FROM Currencies")
    List<CurrenciesEntity> getAllFromCurrencies();
}
