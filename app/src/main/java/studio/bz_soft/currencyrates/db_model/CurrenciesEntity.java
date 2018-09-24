package studio.bz_soft.currencyrates.db_model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Currencies")
public final class CurrenciesEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private final int _id;
    @ColumnInfo(name = "curID")
    private final int curId;
    @ColumnInfo(name = "curParentID")
    private final int curParentId;
    @ColumnInfo(name = "curAbbreviation")
    private final String curAbbreviation;
    @ColumnInfo(name = "curName")
    private final String curName;
    @ColumnInfo(name = "curQuotName")
    private final String curQuotName;

    public CurrenciesEntity(final int _id, final int curId, final int curParentId,
                            final String curAbbreviation,
                            final String curName, final String curQuotName) {
        this._id = _id;
        this.curId = curId;
        this.curParentId = curParentId;
        this.curAbbreviation = curAbbreviation;
        this.curName = curName;
        this.curQuotName = curQuotName;
    }

    public int get_id() {
        return _id;
    }

    public int getCurId() {
        return curId;
    }

    public int getCurParentId() {
        return curParentId;
    }

    public String getCurAbbreviation() {
        return curAbbreviation;
    }

    public String getCurName() {
        return curName;
    }

    public String getCurQuotName() {
        return curQuotName;
    }
}
