package studio.bz_soft.currencyrates;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import studio.bz_soft.currencyrates.net.RequestData;
import studio.bz_soft.currencyrates.net.WebServices;

public class SplashScreenActivity extends AppCompatActivity {

    private final static String TAG = SplashScreenActivity.class.getSimpleName();

    private static final String METHOD_GET = "GET";
    private static final String DATA = "";
    private static final String COMMAND = "";

    private static final String ERROR_MESSAGE_INTERNET = "No INTERNET connection!..";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, MainActivity.class);
        String URL = String.format("%s%s", MainActivity.API_URL, MainActivity.CURRENCIES);
        try {
            Object obj = WebServices.getInstance().
                    requestInfo(new RequestData(URL, DATA, METHOD_GET, COMMAND),
                            WebServices.SELECTOR_CURRENCIES);
            Log.d(TAG, "Object: " + obj);
        } catch (NullPointerException ex) {
            if (BuildConfig.DEBUG) {
                Log.d(TAG, ERROR_MESSAGE_INTERNET);
            }
        }

        startActivity(intent);
        finish();
    }
}
