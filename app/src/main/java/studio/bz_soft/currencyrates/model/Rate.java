package studio.bz_soft.currencyrates.model;

import com.google.gson.annotations.SerializedName;

public final class Rate {

    @SerializedName("Cur_ID")
    private final int curID;
    @SerializedName("Date")
    private final String date;
    @SerializedName("Cur_Abbreviation")
    private final String curAbbreviation;
    @SerializedName("Cur_Scale")
    private final int curScale;
    @SerializedName("Cur_Name")
    private final String curName;
    @SerializedName("Cur_OfficialRate")
    private final double curOfficialRate;

    public Rate(final int curID, final String date, final String curAbbreviation,
                final int curScale, final String curName, final double curOfficialRate) {
        this.curID = curID;
        this.date = date;
        this.curAbbreviation = curAbbreviation;
        this.curScale = curScale;
        this.curName = curName;
        this.curOfficialRate = curOfficialRate;
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

    public int getCurScale() {
        return curScale;
    }

    public String getCurName() {
        return curName;
    }

    public double getCurOfficialRate() {
        return curOfficialRate;
    }
}
