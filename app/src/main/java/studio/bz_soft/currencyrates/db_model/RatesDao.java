package studio.bz_soft.currencyrates.db_model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface RatesDao {

    @Query("SELECT * FROM Rates")
    LiveData<List<RatesEntity>> getAllFromRates();

    @Insert
    void insert(RatesEntity ratesEntity);

    @Delete
    void deleteAll(RatesEntity ratesEntity);
}
