package studio.bz_soft.currencyrates.db_model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Rates")
public final class RatesEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private final int _id;
    @ColumnInfo(name = "curID")
    private final int curID;
    @ColumnInfo(name = "date")
    private final String date;
    @ColumnInfo(name = "curAbbreviation")
    private final String curAbbreviation;
    @ColumnInfo(name = "curScale")
    private final String curScale;
    @ColumnInfo(name = "curName")
    private final String curName;
    @ColumnInfo(name = "curOfficialRate")
    private final double curOfficialRate;

    public RatesEntity(final int _id, final int curID, final String date,
                       final String curAbbreviation,
                       final String curScale, final String curName, final double curOfficialRate) {
        this._id = _id;
        this.curID = curID;
        this.date = date;
        this.curAbbreviation = curAbbreviation;
        this.curScale = curScale;
        this.curName = curName;
        this.curOfficialRate = curOfficialRate;
    }

    public int get_id() {
        return _id;
    }

    public int getCurID() {
        return curID;
    }

    public String getDate() {
        return date;
    }

    public String getCurAbbreviation() {
        return curAbbreviation;
    }

    public String getCurScale() {
        return curScale;
    }

    public String getCurName() {
        return curName;
    }

    public double getCurOfficialRate() {
        return curOfficialRate;
    }
}
