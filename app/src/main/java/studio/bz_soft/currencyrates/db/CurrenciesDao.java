package studio.bz_soft.currencyrates.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import studio.bz_soft.currencyrates.model.Currency;
import java.util.List;

@Dao
public interface CurrenciesDao {

    @Query("SELECT * FROM Currencies")
    List<CurrenciesEntity> getAllFromCurrencies();

    @Insert
    void insert(Currency currency);
}
