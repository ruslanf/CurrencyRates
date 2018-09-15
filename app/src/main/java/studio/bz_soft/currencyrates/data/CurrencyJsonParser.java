package studio.bz_soft.currencyrates.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CurrencyJsonParser {

    public ArrayList<Currency> parseJson(Reader reader, Class<Currency> inputClass) {

        Type jsonType = new TypeToken<ArrayList<Currency>>() {}.getType();
        ArrayList<Currency> result = new Gson().fromJson(reader, jsonType);

        return result;
    }
}
