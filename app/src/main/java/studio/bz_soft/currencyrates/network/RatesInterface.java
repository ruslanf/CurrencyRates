package studio.bz_soft.currencyrates.network;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface RatesInterface {

    @GET("Rate")
    Call<List<RatesInterface>> listRates(@QueryMap Map<String, String> data);
}
