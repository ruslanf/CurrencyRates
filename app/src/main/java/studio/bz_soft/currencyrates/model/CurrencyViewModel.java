package studio.bz_soft.currencyrates.model;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

public final class CurrencyViewModel implements Comparable<CurrencyViewModel> {

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

    @Override
    public int compareTo(@NonNull CurrencyViewModel o) {
        return this.getCurrency().getCurAbbreviation()
                .compareTo(o.getCurrency().getCurAbbreviation());
//        if (!this.getCurrency().getCurAbbreviation()
//                .equalsIgnoreCase(o.getCurrency().getCurAbbreviation())) {
//            return this.getCurrency().getCurAbbreviation()
//                    .compareTo(o.getCurrency().getCurAbbreviation());
//        } else {
//            return 0;
//        }
    }
}
