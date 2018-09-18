package studio.bz_soft.currencyrates.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Currencies")
public class CurrenciesEntity {

    @PrimaryKey(autoGenerate = true)
    private int _id;
    @ColumnInfo(name = "curID")
    private int curId;
    @ColumnInfo(name = "curParentID")
    private int curParentId;
    @ColumnInfo(name = "curAbbreviation")
    private String curAbbreviation;
    @ColumnInfo(name = "curName")
    private String curName;
    @ColumnInfo(name = "curQuotName")
    private String curQuotName;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getCurId() {
        return curId;
    }

    public void setCurId(int curId) {
        this.curId = curId;
    }

    public int getCurParentId() {
        return curParentId;
    }

    public void setCurParentId(int curParentId) {
        this.curParentId = curParentId;
    }

    public String getCurAbbreviation() {
        return curAbbreviation;
    }

    public void setCurAbbreviation(String curAbbreviation) {
        this.curAbbreviation = curAbbreviation;
    }

    public String getCurName() {
        return curName;
    }

    public void setCurName(String curName) {
        this.curName = curName;
    }

    public String getCurQuotName() {
        return curQuotName;
    }

    public void setCurQuotName(String curQuotName) {
        this.curQuotName = curQuotName;
    }
}
