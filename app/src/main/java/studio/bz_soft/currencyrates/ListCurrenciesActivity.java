package studio.bz_soft.currencyrates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListCurrenciesActivity extends AppCompatActivity {


    private ListView listViewCurrencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_currencies);

        listViewCurrencies = findViewById(R.id.listViewCurrencies);
    }
}
