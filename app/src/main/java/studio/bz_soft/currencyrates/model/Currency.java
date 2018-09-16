package studio.bz_soft.currencyrates.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Currency implements Parcelable {

    @SerializedName("Cur_ID")
    private int curID;
    @Nullable
    @SerializedName("Cur_ParentID")
    private int curParentID;
    @SerializedName("Cur_Code")
    private String curCode;
    @SerializedName("Cur_Abbreviation")
    private String curAbbreviation;
    @SerializedName("Cur_Name")
    private String curName;
    @SerializedName("Cur_Name_Bel")
    private String curNameBel;
    @SerializedName("Cur_Name_Eng")
    private String curNameEng;
    @SerializedName("Cur_QuotName")
    private String curQuotName;
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

    public Currency() {

    }

    public Currency(int curID, int curParentID, String curCode, String curAbbreviation, String curName, String curQuotName) {
        this.curID = curID;
        this.curParentID = curParentID;
        this.curCode = curCode;
        this.curAbbreviation = curAbbreviation;
        this.curName = curName;
        this.curQuotName = curQuotName;
    }

    protected Currency(Parcel in) {
        curID = in.readInt();
        curParentID = in.readInt();
        curCode = in.readString();
        curAbbreviation = in.readString();
        curName = in.readString();
        curNameBel = in.readString();
        curNameEng = in.readString();
        curQuotName = in.readString();
        curQuotNameBel = in.readString();
        curQuotNameEng = in.readString();
        curNameMulti = in.readString();
        curNameBelMulti = in.readString();
        curNameEngMulti = in.readString();
        curScale = in.readInt();
        curPeriodicity = in.readInt();
        curDateStart = in.readString();
        curDateEnd = in.readString();
    }

    public static final Creator<Currency> CREATOR = new Creator<Currency>() {
        @Override
        public Currency createFromParcel(Parcel in) {
            return new Currency(in);
        }

        @Override
        public Currency[] newArray(int size) {
            return new Currency[size];
        }
    };

    public int getCurID() {
        return curID;
    }

    public void setCurID(int curID) {
        this.curID = curID;
    }

    public int getCurParentID() {
        return curParentID;
    }

    public void setCurParentID(int curParentID) {
        this.curParentID = curParentID;
    }

    public String getCurCode() {
        return curCode;
    }

    public void setCurCode(String curCode) {
        this.curCode = curCode;
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

    public String getCurNameBel() {
        return curNameBel;
    }

    public void setCurNameBel(String curNameBel) {
        this.curNameBel = curNameBel;
    }

    public String getCurNameEng() {
        return curNameEng;
    }

    public void setCurNameEng(String curNameEng) {
        this.curNameEng = curNameEng;
    }

    public String getCurQuotName() {
        return curQuotName;
    }

    public void setCurQuotName(String curQuotName) {
        this.curQuotName = curQuotName;
    }

    public String getCurQuotNameBel() {
        return curQuotNameBel;
    }

    public void setCurQuotNameBel(String curQuotNameBel) {
        this.curQuotNameBel = curQuotNameBel;
    }

    public String getCurQuotNameEng() {
        return curQuotNameEng;
    }

    public void setCurQuotNameEng(String curQuotNameEng) {
        this.curQuotNameEng = curQuotNameEng;
    }

    public String getCurNameMulti() {
        return curNameMulti;
    }

    public void setCurNameMulti(String curNameMulti) {
        this.curNameMulti = curNameMulti;
    }

    public String getCurNameBelMulti() {
        return curNameBelMulti;
    }

    public void setCurNameBelMulti(String curNameBelMulti) {
        this.curNameBelMulti = curNameBelMulti;
    }

    public String getCurNameEngMulti() {
        return curNameEngMulti;
    }

    public void setCurNameEngMulti(String curNameEngMulti) {
        this.curNameEngMulti = curNameEngMulti;
    }

    public int getCurScale() {
        return curScale;
    }

    public void setCurScale(int curScale) {
        this.curScale = curScale;
    }

    public int getCurPeriodicity() {
        return curPeriodicity;
    }

    public void setCurPeriodicity(int curPeriodicity) {
        this.curPeriodicity = curPeriodicity;
    }

    public String getCurDateStart() {
        return curDateStart;
    }

    public void setCurDateStart(String curDateStart) {
        this.curDateStart = curDateStart;
    }

    public String getCurDateEnd() {
        return curDateEnd;
    }

    public void setCurDateEnd(String curDateEnd) {
        this.curDateEnd = curDateEnd;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(curID);
        dest.writeInt(curParentID);
        dest.writeString(curCode);
        dest.writeString(curAbbreviation);
        dest.writeString(curName);
        dest.writeString(curNameBel);
        dest.writeString(curNameEng);
        dest.writeString(curQuotName);
        dest.writeString(curQuotNameBel);
        dest.writeString(curQuotNameEng);
        dest.writeString(curNameMulti);
        dest.writeString(curNameBelMulti);
        dest.writeString(curNameEngMulti);
        dest.writeInt(curScale);
        dest.writeInt(curPeriodicity);
        dest.writeString(curDateStart);
        dest.writeString(curDateEnd);
    }
}
