package studio.bz_soft.currencyrates.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Rates implements Parcelable {

    @SerializedName("Cur_ID")
    private int curID;
    @SerializedName("Date")
    private String date;
    @SerializedName("Cur_Abbreviation")
    private String curAbbreviation;
    @SerializedName("Cur_Scale")
    private int curScale;
    @SerializedName("Cur_Name")
    private String curName;
    @Nullable
    @SerializedName("Cur_OfficialRate")
    private double curOfficialRate;

    public Rates(int curID, String date, String curAbbreviation, int curScale, String curName, double curOfficialRate) {
        this.curID = curID;
        this.date = date;
        this.curAbbreviation = curAbbreviation;
        this.curScale = curScale;
        this.curName = curName;
        this.curOfficialRate = curOfficialRate;
    }

    protected Rates(Parcel in) {
        curID = in.readInt();
        date = in.readString();
        curAbbreviation = in.readString();
        curScale = in.readInt();
        curName = in.readString();
        curOfficialRate = in.readFloat();
    }

    public static final Creator<Rates> CREATOR = new Creator<Rates>() {
        @Override
        public Rates createFromParcel(Parcel in) {
            return new Rates(in);
        }

        @Override
        public Rates[] newArray(int size) {
            return new Rates[size];
        }
    };

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

    public int getCurScale() {
        return curScale;
    }

    public void setCurScale(int curScale) {
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

    public void setCurOfficialRate(float curOfficialRate) {
        this.curOfficialRate = curOfficialRate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(curID);
        dest.writeString(date);
        dest.writeString(curAbbreviation);
        dest.writeInt(curScale);
        dest.writeString(curName);
        dest.writeDouble(curOfficialRate);
    }
}
