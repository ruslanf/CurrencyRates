package studio.bz_soft.currencyrates;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CursorAdapter;
import android.widget.ListView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import studio.bz_soft.currencyrates.data.CurrenciesList;
import studio.bz_soft.currencyrates.data.CurrencyAdapter;
import studio.bz_soft.currencyrates.threads.LoadCurrenciesTask;

public class ListCurrenciesActivity extends AppCompatActivity {

    private static final String TAG = ListCurrenciesActivity.class.getSimpleName();

    private Handler loadCurrenciesHandler;
    private ExecutorService executorService;

    private ListView listViewCurrencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_currencies);

        listViewCurrencies = findViewById(R.id.listViewCurrencies);

        Intent intent = getIntent();

        executorService = Executors.newSingleThreadExecutor();

        loadCurrenciesHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                CurrenciesList currenciesList = bundle.getParcelable(LoadCurrenciesTask.LOAD_CURRENCIES_KEY);

                CurrencyAdapter currencyAdapter = new CurrencyAdapter(ListCurrenciesActivity.this,
                        getApplicationContext(),
                        R.layout.row_currencies_layout,
                        R.id.textViewAbbreviation,
                        R.id.textViewCurrencyName,
                        currenciesList.getCurrencyList());
                listViewCurrencies.setAdapter(currencyAdapter);
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onStart()...");
        }

        Runnable runnable = new LoadCurrenciesTask(loadCurrenciesHandler);
        executorService.submit(runnable);
    }
}
