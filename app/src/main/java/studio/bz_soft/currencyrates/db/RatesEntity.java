package studio.bz_soft.currencyrates.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Rates")
public class RatesEntity {

    @PrimaryKey(autoGenerate = true)
    private int _id;
    @ColumnInfo(name = "curID")
    private int curID;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "curAbbreviation")
    private String curAbbreviation;
    @ColumnInfo(name = "curScale")
    private String curScale;
    @ColumnInfo(name = "curName")
    private String curName;
    @ColumnInfo(name = "curOfficialRate")
    private double curOfficialRate;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getCurID() {
        return curID;
    }

    public void setCurID(int curID) {
        this.curID = curID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurAbbreviation() {
        return curAbbreviation;
    }

    public void setCurAbbreviation(String curAbbreviation) {
        this.curAbbreviation = curAbbreviation;
    }

    public String getCurScale() {
        return curScale;
    }

    public void setCurScale(String curScale) {
        this.curScale = curScale;
    }

    public String getCurName() {
        return curName;
    }

    public void setCurName(String curName) {
        this.curName = curName;
    }

    public double getCurOfficialRate() {
        return curOfficialRate;
    }

    public void setCurOfficialRate(double curOfficialRate) {
        this.curOfficialRate = curOfficialRate;
    }
}
