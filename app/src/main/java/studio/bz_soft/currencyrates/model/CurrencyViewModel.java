package studio.bz_soft.currencyrates.model;

import android.graphics.Bitmap;

public final class CurrencyViewModel {

    private final Currency currency;
    private final Bitmap countryImage;

    public CurrencyViewModel(final Currency currency, final Bitmap countryImage) {
        this.currency = currency;
        this.countryImage = countryImage;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Bitmap getCountryImage() {
        return countryImage;
    }
}
