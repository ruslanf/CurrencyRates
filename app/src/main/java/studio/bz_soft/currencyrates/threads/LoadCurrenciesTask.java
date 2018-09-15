package studio.bz_soft.currencyrates.threads;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import studio.bz_soft.currencyrates.MainActivity;
import studio.bz_soft.currencyrates.data.CurrenciesList;
import studio.bz_soft.currencyrates.net.RequestData;
import studio.bz_soft.currencyrates.net.WebServices;

public class LoadCurrenciesTask implements Runnable {

    private static final String METHOD_GET = "GET";
    private static final String DATA = "";
    private static final String COMMAND = "";

    public static final String LOAD_CURRENCIES_KEY = "CURRENCIES";

    private Handler handler;

    public LoadCurrenciesTask(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        String URL = String.format("%s%s", MainActivity.API_URL, MainActivity.CURRENCIES);
        CurrenciesList currenciesList = (CurrenciesList) WebServices.getInstance().
                requestInfo(new RequestData(URL, DATA, METHOD_GET, COMMAND),
                        WebServices.SELECTOR_CURRENCIES);

        Message message = handler.obtainMessage();
        Bundle bundle = new Bundle();

        bundle.putParcelable(LOAD_CURRENCIES_KEY, currenciesList);

        message.setData(bundle);
        handler.sendMessage(message);
    }
}
