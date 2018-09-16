package studio.bz_soft.currencyrates.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class CurrenciesList implements Parcelable {

    private List<Currency> currencyList;

    public CurrenciesList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    protected CurrenciesList(Parcel in) {
        currencyList = in.createTypedArrayList(Currency.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(currencyList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CurrenciesList> CREATOR = new Creator<CurrenciesList>() {
        @Override
        public CurrenciesList createFromParcel(Parcel in) {
            return new CurrenciesList(in);
        }

        @Override
        public CurrenciesList[] newArray(int size) {
            return new CurrenciesList[size];
        }
    };

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }
}
