package studio.bz_soft.currencyrates.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Currency implements Parcelable {

    private int Cur_ID;
    private int Cur_ParentID;
    private String Cur_Code;
    private String Cur_Abbreviation;
    private String Cur_Name;
    private String Cur_Name_Bel;
    private String Cur_Name_Eng;
    private String Cur_QuotName;
    private String Cur_QuotName_Bel;
    private String Cur_QuotName_Eng;
    private String Cur_NameMulti;
    private String Cur_Name_BelMulti;
    private String Cur_Name_EngMulti;
    private int Cur_Scale;
    private int Cur_Periodicity;    // периодичность установления курса (0 – ежедневно, 1 – ежемесячно)
    private String Cur_DateStart;
    private String Cur_DateEnd;

    public Currency(int cur_ID, int cur_ParentID, String cur_Code, String cur_Abbreviation, String cur_Name, String cur_QuotName) {
        Cur_ID = cur_ID;
        Cur_ParentID = cur_ParentID;
        Cur_Code = cur_Code;
        Cur_Abbreviation = cur_Abbreviation;
        Cur_Name = cur_Name;
        Cur_QuotName = cur_QuotName;
    }

    protected Currency(Parcel in) {
        Cur_ID = in.readInt();
        Cur_ParentID = in.readInt();
        Cur_Code = in.readString();
        Cur_Abbreviation = in.readString();
        Cur_Name = in.readString();
        Cur_Name_Bel = in.readString();
        Cur_Name_Eng = in.readString();
        Cur_QuotName = in.readString();
        Cur_QuotName_Bel = in.readString();
        Cur_QuotName_Eng = in.readString();
        Cur_NameMulti = in.readString();
        Cur_Name_BelMulti = in.readString();
        Cur_Name_EngMulti = in.readString();
        Cur_Scale = in.readInt();
        Cur_Periodicity = in.readInt();
        Cur_DateStart = in.readString();
        Cur_DateEnd = in.readString();
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

    public int getCur_ID() {
        return Cur_ID;
    }

    public void setCur_ID(int cur_ID) {
        Cur_ID = cur_ID;
    }

    public int getCur_ParentID() {
        return Cur_ParentID;
    }

    public void setCur_ParentID(int cur_ParentID) {
        Cur_ParentID = cur_ParentID;
    }

    public String getCur_Code() {
        return Cur_Code;
    }

    public void setCur_Code(String cur_Code) {
        Cur_Code = cur_Code;
    }

    public String getCur_Abbreviation() {
        return Cur_Abbreviation;
    }

    public void setCur_Abbreviation(String cur_Abbreviation) {
        Cur_Abbreviation = cur_Abbreviation;
    }

    public String getCur_Name() {
        return Cur_Name;
    }

    public void setCur_Name(String cur_Name) {
        Cur_Name = cur_Name;
    }

    public String getCur_Name_Bel() {
        return Cur_Name_Bel;
    }

    public void setCur_Name_Bel(String cur_Name_Bel) {
        Cur_Name_Bel = cur_Name_Bel;
    }

    public String getCur_Name_Eng() {
        return Cur_Name_Eng;
    }

    public void setCur_Name_Eng(String cur_Name_Eng) {
        Cur_Name_Eng = cur_Name_Eng;
    }

    public String getCur_QuotName() {
        return Cur_QuotName;
    }

    public void setCur_QuotName(String cur_QuotName) {
        Cur_QuotName = cur_QuotName;
    }

    public String getCur_QuotName_Bel() {
        return Cur_QuotName_Bel;
    }

    public void setCur_QuotName_Bel(String cur_QuotName_Bel) {
        Cur_QuotName_Bel = cur_QuotName_Bel;
    }

    public String getCur_QuotName_Eng() {
        return Cur_QuotName_Eng;
    }

    public void setCur_QuotName_Eng(String cur_QuotName_Eng) {
        Cur_QuotName_Eng = cur_QuotName_Eng;
    }

    public String getCur_NameMulti() {
        return Cur_NameMulti;
    }

    public void setCur_NameMulti(String cur_NameMulti) {
        Cur_NameMulti = cur_NameMulti;
    }

    public String getCur_Name_BelMulti() {
        return Cur_Name_BelMulti;
    }

    public void setCur_Name_BelMulti(String cur_Name_BelMulti) {
        Cur_Name_BelMulti = cur_Name_BelMulti;
    }

    public String getCur_Name_EngMulti() {
        return Cur_Name_EngMulti;
    }

    public void setCur_Name_EngMulti(String cur_Name_EngMulti) {
        Cur_Name_EngMulti = cur_Name_EngMulti;
    }

    public int getCur_Scale() {
        return Cur_Scale;
    }

    public void setCur_Scale(int cur_Scale) {
        Cur_Scale = cur_Scale;
    }

    public int getCur_Periodicity() {
        return Cur_Periodicity;
    }

    public void setCur_Periodicity(int cur_Periodicity) {
        Cur_Periodicity = cur_Periodicity;
    }

    public String getCur_DateStart() {
        return Cur_DateStart;
    }

    public void setCur_DateStart(String cur_DateStart) {
        Cur_DateStart = cur_DateStart;
    }

    public String getCur_DateEnd() {
        return Cur_DateEnd;
    }

    public void setCur_DateEnd(String cur_DateEnd) {
        Cur_DateEnd = cur_DateEnd;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Cur_ID);
        dest.writeInt(Cur_ParentID);
        dest.writeString(Cur_Code);
        dest.writeString(Cur_Abbreviation);
        dest.writeString(Cur_Name);
        dest.writeString(Cur_Name_Bel);
        dest.writeString(Cur_Name_Eng);
        dest.writeString(Cur_QuotName);
        dest.writeString(Cur_QuotName_Bel);
        dest.writeString(Cur_QuotName_Eng);
        dest.writeString(Cur_NameMulti);
        dest.writeString(Cur_Name_BelMulti);
        dest.writeString(Cur_Name_EngMulti);
        dest.writeInt(Cur_Scale);
        dest.writeInt(Cur_Periodicity);
        dest.writeString(Cur_DateStart);
        dest.writeString(Cur_DateEnd);
    }
}
