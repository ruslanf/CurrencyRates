package studio.bz_soft.currencyrates.net;

import android.util.Log;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import studio.bz_soft.currencyrates.BuildConfig;
import studio.bz_soft.currencyrates.data.ListCurrencyParser;

/**
 * Created by Black_Zerg on 27.01.2018.
 */

public class WebServices {

    private static final String TAG = WebServices.class.getSimpleName();

    private static final String RESPONSE_CODE = "ResponseCode";
    private static final String DATA = "Data";
    private static final int RESPONSE_CODE_200 = 200;
    public static final String SELECTOR_SEARCH_INFO = "search";

    private static final WebServices instance = new WebServices();

    /**
     * Empty class constructor
     */
    private WebServices() {

    }

    public static WebServices getInstance() {
        return instance;
    }

    /**
     *
     * @param requestData contains request for server
     * @param selector for choose request
     * @return <i>Object</i> contain answer from request
     */
    public Object requestInfo(RequestData requestData, String selector) {
        String[] params = new String[]{
                requestData.getUrl(),
                requestData.getData(),
                requestData.getMethod(),
                requestData.getCommand()};
        Object result = null;

        HashMap out = requestExecute(params);
        try {
            switch ((Integer) out.get(RESPONSE_CODE)) {
                case RESPONSE_CODE_200:
                    String data = out.get(DATA).toString();
                    try {
                        switch(selector) {
                            case SELECTOR_SEARCH_INFO:
                                result = new ListCurrencyParser().parse(new StringReader(data));
                                break;
                        }
                    } catch (IOException ex) {
                        if (BuildConfig.DEBUG) {
                            Log.e(TAG, "Unit parsing failed ", ex);
                        }
                    }
                    break;
            }
        } catch (NullPointerException ex) {
            if (BuildConfig.DEBUG) {
                Log.e(TAG, "Request! No connection ", ex);
            }
        }
        return result;
    }

    /**
     * @param params <i>Array</i> contains request for server
     * @return HashMap from AsyncTask
     */
    private HashMap requestExecute(String[] params) {
        HashMap result = new HashMap();
        try {
            result = new HttpRequest().execute(params).get();
        } catch (InterruptedException ex) {
            if (BuildConfig.DEBUG) {
                Log.e(TAG, "requestExecute InterruptedException ", ex);
            }
        } catch (ExecutionException ex) {
            if (BuildConfig.DEBUG) {
                Log.e(TAG, "requestExecute ExecutionException ", ex);
            }
        }
        return result;
    }
}
