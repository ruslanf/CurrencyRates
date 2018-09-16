package studio.bz_soft.currencyrates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import studio.bz_soft.currencyrates.model.Currency;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    public static final String API_URL = "http://www.nbrb.by/API/ExRates/";
    public static final String CURRENCIES = "Currencies";
    public static final String RATES = "RatesInterface";

    private Intent intent;
    private List<Currency> listCurrency;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_list_currencies:
                Intent intent = new Intent(this, ListCurrenciesActivity.class);
//                ArrayList<? extends Currency> currencyList = this.intent.getParcelableArrayListExtra(SplashScreenActivity.INTENT_CURRENCIES_KEY);
//                intent.putParcelableArrayListExtra(SplashScreenActivity.INTENT_CURRENCIES_KEY, currencyList);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        intent = getIntent();
//        listCurrency = intent.getParcelableArrayListExtra(SplashScreenActivity.INTENT_CURRENCIES_KEY);
    }
}
