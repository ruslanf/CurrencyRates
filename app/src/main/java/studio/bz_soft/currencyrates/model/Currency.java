package studio.bz_soft.currencyrates.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public final class Currency implements Comparable<Currency> {

    @SerializedName("Cur_ID")
    private final int curID;
    @Nullable
    @SerializedName("Cur_ParentID")
    private final int curParentID;
    @SerializedName("Cur_Code")
    private final String curCode;
    @SerializedName("Cur_Abbreviation")
    private final String curAbbreviation;
    @SerializedName("Cur_Name")
    private final String curName;
    @SerializedName("Cur_Name_Bel")
    private String curNameBel;
    @SerializedName("Cur_Name_Eng")
    private String curNameEng;
    @SerializedName("Cur_QuotName")
    private final String curQuotName;
    @SerializedName("Cur_QuotName_Bel")
    private String curQuotNameBel;
    @SerializedName("Cur_QuotName_Eng")
    private String curQuotNameEng;
    @SerializedName("Cur_NameMulti")
    private String curNameMulti;
    @Nullable
    @SerializedName("Cur_Name_BelMulti")
    private String curNameBelMulti;
    @Nullable
    @SerializedName("Cur_Name_EngMulti")
    private String curNameEngMulti;
    @SerializedName("Cur_Scale")
    private int curScale;
    @SerializedName("Cur_Periodicity")
    private int curPeriodicity;    // периодичность установления курса (0 – ежедневно, 1 – ежемесячно)
    @SerializedName("Cur_DateStart")
    private String curDateStart;
    @SerializedName("Cur_DateEnd")
    private String curDateEnd;

    public Currency(final int curID, final int curParentID, final String curCode,
                    final String curAbbreviation, final String curName, final String curQuotName) {
        this.curID = curID;
        this.curParentID = curParentID;
        this.curCode = curCode;
        this.curAbbreviation = curAbbreviation;
        this.curName = curName;
        this.curQuotName = curQuotName;
    }

    public int getCurID() {
        return curID;
    }

    @Nullable
    public int getCurParentID() {
        return curParentID;
    }

    public String getCurCode() {
        return curCode;
    }

    public String getCurAbbreviation() {
        return curAbbreviation;
    }

    public String getCurName() {
        return curName;
    }

    public String getCurNameBel() {
        return curNameBel;
    }

    public String getCurNameEng() {
        return curNameEng;
    }

    public String getCurQuotName() {
        return curQuotName;
    }

    public String getCurQuotNameBel() {
        return curQuotNameBel;
    }

    public String getCurQuotNameEng() {
        return curQuotNameEng;
    }

    public String getCurNameMulti() {
        return curNameMulti;
    }

    @Nullable
    public String getCurNameBelMulti() {
        return curNameBelMulti;
    }

    @Nullable
    public String getCurNameEngMulti() {
        return curNameEngMulti;
    }

    public int getCurScale() {
        return curScale;
    }

    public int getCurPeriodicity() {
        return curPeriodicity;
    }

    public String getCurDateStart() {
        return curDateStart;
    }

    public String getCurDateEnd() {
        return curDateEnd;
    }

    @Override
    public int compareTo(@NonNull Currency o) {
        return this.getCurAbbreviation().compareTo(o.getCurAbbreviation());
    }
}
