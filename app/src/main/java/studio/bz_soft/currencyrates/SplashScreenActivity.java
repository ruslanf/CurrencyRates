package studio.bz_soft.currencyrates;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SplashScreenActivity extends AppCompatActivity {

    private final static String TAG = SplashScreenActivity.class.getSimpleName();

    private static final String METHOD_GET = "GET";
    private static final String DATA = "";
    private static final String COMMAND = "";

    public static final String INTENT_CURRENCIES_KEY = "CURRENCIES";
    public static final String INTENT_RATES_KEY = "RATES";

    private static final String ERROR_MESSAGE_INTERNET = "No INTERNET connection!..";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, MainActivity.class);

        //TODO Сделать загрузку иконок в отдельном потоке

//        String URL = String.format("%s%s", MainActivity.API_URL, MainActivity.CURRENCIES);
//        try {
//            List<Currency> listCurrencies = (List<Currency>) WebServices.getInstance().
//                    requestInfo(new RequestData(URL, DATA, METHOD_GET, COMMAND),
//                            WebServices.SELECTOR_CURRENCIES);
//            URL = String.format("%s%s", MainActivity.API_URL, MainActivity.RATES);
//            List<RatesInterface> listRates = (List<RatesInterface>) WebServices.getInstance().
//                    requestInfo(new RequestData(URL, DATA, METHOD_GET, COMMAND),
//                            WebServices.SELECTOR_CURRENCIES);
//            intent.putExtra(INTENT_CURRENCIES_KEY, (Parcelable) listCurrencies);
//            intent.putExtra(INTENT_RATES_KEY, (Parcelable) listRates);
//            intent.putParcelableArrayListExtra(INTENT_CURRENCIES_KEY, (ArrayList<? extends Parcelable>) listCurrencies);
//            intent.putParcelableArrayListExtra(INTENT_RATES_KEY, (ArrayList<? extends Parcelable>) listRates);
//        } catch (NullPointerException ex) {
//            if (BuildConfig.DEBUG) {
//                Log.d(TAG, ERROR_MESSAGE_INTERNET);
//            }
//        }

        startActivity(intent);
        finish();
    }
}
