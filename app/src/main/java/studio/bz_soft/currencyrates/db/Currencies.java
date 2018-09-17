package studio.bz_soft.currencyrates.db;

import com.google.gson.annotations.SerializedName;

public class Currencies {

    @SerializedName("_id")
    private int id;
    @SerializedName("curID")
    private int curId;
    @SerializedName("curParentID")
    private int curParentId;
    @SerializedName("curAbbreviation")
    private String curAbbreviation;
    @SerializedName("curName")
    private String curName;
    @SerializedName("curQuotName")
    private String curQuotName;
}
