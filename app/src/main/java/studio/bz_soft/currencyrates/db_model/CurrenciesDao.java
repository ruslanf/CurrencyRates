package studio.bz_soft.currencyrates.db_model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import studio.bz_soft.currencyrates.db_model.CurrenciesEntity;

@Dao
public interface CurrenciesDao {

    @Query("SELECT * FROM Currencies")
    List<CurrenciesEntity> getAllFromCurrencies();

    @Insert
    void insert(CurrenciesEntity currenciesEntity);

    //("DELETE FORM Currencies")
    @Delete
    void deleteAll(CurrenciesEntity currenciesEntity);
}
