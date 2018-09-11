package studio.bz_soft.currencyrates.net;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import studio.bz_soft.currencyrates.BuildConfig;

/**
 * Created by Black_Zerg on 15.11.2017 18:06.
 */

public class HttpRequest extends AsyncTask<Object, Void, HashMap> {

    private static final String TAG = HttpRequest.class.getSimpleName();

    private static final String METHOD_GET = "METHOD_GET";
    private static final String METHOD_POST = "POST";
    private static final String RESPONSE_CODE = "ResponseCode";
    private static final String RESPONSE_MESSAGE = "responseMessage";
    private static final String DATA = "Data";
    private static final String ACCEPT = "Accept";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_TYPE = "application/json";
    private static final String UNICODE_CHARSET = "UTF-8";
    private static final int RESPONSE_CODE_400 = 400;
    private static final int RESPONSE_CODE_418 = 418;


    public HttpRequest() {
        super();
    }

    @Override
    protected HashMap doInBackground(Object... params) {
        publishProgress();
        HashMap<String, Object> result = new HashMap<>();
        try {
            String urlString = params[0].toString();
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            String requestMethod = params[2].toString();
            switch (requestMethod) {
                case METHOD_GET:
                    urlConnection.setDoOutput(false);
                    urlConnection.setRequestProperty(ACCEPT, APPLICATION_TYPE);
                    urlConnection.setRequestProperty(CONTENT_TYPE, APPLICATION_TYPE);
                    break;
                case METHOD_POST:
                    String data = params[1].toString();
                    urlConnection.setDoOutput(true);
                    try (OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream())) {
                        out.write(data);
                        out.flush();
                    }
                    break;
                default:
                    break;
            }
            urlConnection.setRequestMethod(requestMethod);
            urlConnection.connect();

            int responseCode = urlConnection.getResponseCode();
            result.put(RESPONSE_CODE, responseCode);
            result.put(RESPONSE_MESSAGE, urlConnection.getResponseMessage());

            StringBuilder outString = new StringBuilder();
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), UNICODE_CHARSET));
                String line;
                while ((line = reader.readLine()) != null) {
                    outString.append(line).append("\n");
                }
                result.put(DATA, outString);
            } catch (IOException ex) {
                if (BuildConfig.DEBUG) {
                    Log.e(TAG, "Error: IOException ", ex);
                }
                result.put(RESPONSE_CODE, RESPONSE_CODE_400);
                result.put(RESPONSE_MESSAGE, "Error: IOException " + ex.getMessage());
                result.put(DATA, "");
            }
        } catch (NullPointerException ex) {
            if (BuildConfig.DEBUG) {
                Log.e(TAG, "Error: URL Exception ", ex);
            }
            result.put(RESPONSE_CODE, RESPONSE_CODE_400);
            result.put(RESPONSE_MESSAGE, "Error: URL Exception " + ex.getMessage());
            result.put(DATA, "");
        } catch (Exception ex) {
            if (BuildConfig.DEBUG) {
                Log.e(TAG, "Exception request: ", ex);
            }
            result.put(RESPONSE_CODE, RESPONSE_CODE_418);
            result.put(RESPONSE_MESSAGE, "Exception request: " + ex.getMessage());
            result.put(DATA, "");
        }
        return result;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(HashMap hashMap) {
        super.onPostExecute(hashMap);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(HashMap hashMap) {
        super.onCancelled(hashMap);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
