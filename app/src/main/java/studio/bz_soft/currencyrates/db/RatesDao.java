package studio.bz_soft.currencyrates.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import studio.bz_soft.currencyrates.model.Rate;

@Dao
public interface RatesDao {

    @Query("SELECT * FROM Rates")
    List<RatesEntity> getAllFromRates();

    @Insert
    void insert(Rate rate);
}
