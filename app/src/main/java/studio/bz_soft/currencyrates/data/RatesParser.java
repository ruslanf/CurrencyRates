package studio.bz_soft.currencyrates.data;

import android.support.annotation.NonNull;
import android.util.JsonReader;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class RatesParser {

    private static final String SELECTOR_CUR_ID = "Cur_ID";
    private static final String SELECTOR_DATE = "Date";
    private static final String SELECTOR_CUR_ABBREVIATION = "Cur_Abbreviation";
    private static final String SELECTOR_CUR_SCALE = "Cur_Scale";
    private static final String SELECTOR_CUR_NAME = "Cur_Name";
    private static final String SELECTOR_CUR_OFFICIAL_RATE = "Cur_OfficialRate";

    public List<Rates> parse(Reader reader) throws IOException {
        try (JsonReader jsonReader = new JsonReader(reader)) {
            return readRates(jsonReader);
        }
    }

    @NonNull
    private List<Rates> readRates(JsonReader reader) throws IOException {
        List<Rates> result = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            int curId = 0;
            String date = "";
            String curAbbreviation = "";
            int curScale = 0;
            String curName = "";
            double curOfficialRate = 0;
            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                switch (name) {
                    case SELECTOR_CUR_ID:
                        curId = reader.nextInt();
                        break;
                    case SELECTOR_DATE:
                        date = reader.nextString();
                        break;
                    case SELECTOR_CUR_ABBREVIATION:
                        curAbbreviation = reader.nextName();
                        break;
                    case SELECTOR_CUR_SCALE:
                        curScale = reader.nextInt();
                        break;
                    case SELECTOR_CUR_NAME:
                        curName = reader.nextString();
                        break;
                    case SELECTOR_CUR_OFFICIAL_RATE:
                        curOfficialRate = reader.nextDouble();
                        break;
                }
            }
            reader.endObject();
            result.add(new Rates(curId, date, curAbbreviation, curScale, curName, curOfficialRate));
        }
        reader.endArray();

        return result;
    }
}
