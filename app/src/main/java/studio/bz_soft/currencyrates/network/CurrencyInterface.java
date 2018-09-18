package studio.bz_soft.currencyrates.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import studio.bz_soft.currencyrates.model.Currency;

public interface CurrencyInterface {

    @GET("CurrenciesEntity")
    Call<List<Currency>> listCurrencies();
}
