package studio.bz_soft.currencyrates;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import studio.bz_soft.currencyrates.db.CurrenciesViewModel;
import studio.bz_soft.currencyrates.db.RatesViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private void startListCurrenciesActivity() {
        Intent intent = new Intent(this, ListCurrenciesActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onDestroy()...");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CurrenciesViewModel currenciesViewModel = ViewModelProviders.of(this).get(CurrenciesViewModel.class);
        currenciesViewModel.getAllCurrenciesList().observe(this, currencies -> {
            //TODO get list currencies
            if (currencies != null) {
                Log.d(TAG, "currencies != null");
            } else {
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "currencies = null");
                }
            }
        });


//        Observable<LiveData<List<CurrenciesEntity>>> currenciesObserver = Observable.
//                (currenciesViewModel.getAllCurrenciesList()) -> {};
////                (LiveData<List<CurrenciesEntity>> listLiveData) -> {};
//        currenciesObserver.onChanged(listLiveData);

//        currenciesViewModel.getAllCurrenciesList().observe(this, currencies -> {
//            //TODO get list currencies
//            if (currencies != null) {
//
//            } else {
//                if (BuildConfig.DEBUG) {
//                    Log.d(TAG, "currencies = null");
//                }
//            }
//        });


        RatesViewModel ratesViewModel = ViewModelProviders.of(this).get(RatesViewModel.class);
//        ratesViewModel.getAllRates().observe(this, rates -> {
//            //TODO update adapter
//        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(this, ListCurrenciesActivity.class);
            startActivity(intent);
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_list_currencies:
                startListCurrenciesActivity();
                break;
            case R.id.action_clear_db:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
