package studio.bz_soft.currencyrates.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import studio.bz_soft.currencyrates.model.Rates;

public class RatesJsonParser {

    public ArrayList<Rates> parseJson(Reader reader, Class<Rates> inputClass) {

        Type jsonType = new TypeToken<ArrayList<Rates>>() {}.getType();
        ArrayList<Rates> result = new Gson().fromJson(reader, jsonType);

        return result;
    }
}
