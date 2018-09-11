package studio.bz_soft.currencyrates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    public static final String API_URL = "http://www.nbrb.by/API/ExRates/";
    public static final String CURRENCIES = "Currencies";
    public static final String RATES = "Rates";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
