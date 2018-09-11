package studio.bz_soft.currencyrates.data;

import android.support.annotation.NonNull;
import android.util.JsonReader;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ListCurrencyParser {

    private static final String SELECTOR_CUR_ID = "Cur_ID";
    private static final String SELECTOR_CUR_PARENT_ID = "Cur_ParentID";
    private static final String SELECTOR_CUR_CODE = "Cur_Code";
    private static final String SELECTOR_CUR_ABBREVIATION = "Cur_Abbreviation";
    private static final String SELECTOR_CUR_NAME = "Cur_Name";
    private static final String SELECTOR_CUR_NAME_BEL = "Cur_Name_Bel";
    private static final String SELECTOR_CUR_NAME_ENG = "Cur_Name_Eng";
    private static final String SELECTOR_CUR_QUOT_NAME = "Cur_QuotName";
    private static final String SELECTOR_CUR_QUOT_NAME_BEL = "Cur_QuotName_Bel";
    private static final String SELECTOR_CUR_QUOT_NAME_ENG = "Cur_QuotName_Eng";
    private static final String SELECTOR_CUR_NAME_MULTI = "Cur_NameMulti";
    private static final String SELECTOR_CUR_NAME_BEL_MULTI = "Cur_Name_BelMulti";
    private static final String SELECTOR_CUR_NAME_ENG_MULTI = "Cur_Name_EngMulti";
    private static final String SELECTOR_CUR_SCALE = "Cur_Scale";
    private static final String SELECTOR_CUR_PERIODICITY = "Cur_Periodicity";
    private static final String SELECTOR_CUR_DATE_START = "Cur_DateStart";
    private static final String SELECTOR_CUR_DATE_END = "Cur_DateEnd";

    public List<Currency> parse(Reader reader) throws IOException {
        try (JsonReader jsonReader = new JsonReader(reader)) {
            return readCurrency(jsonReader);
        }
    }

    @NonNull
    private List<Currency> readCurrency(JsonReader reader) throws IOException {
        List<Currency> result = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            int curId = 0;
            int curParentId = 0;
            String curCode = "";
            String curAbbreviation = "";
            String curName = "";
            String curQuotName = "";
            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                switch (name) {
                    case SELECTOR_CUR_ID:
                        curId = reader.nextInt();
                        break;
                    case SELECTOR_CUR_PARENT_ID:
                        curParentId = reader.nextInt();
                        break;
                    case SELECTOR_CUR_CODE:
                        curCode = reader.nextString();
                        break;
                    case SELECTOR_CUR_ABBREVIATION:
                        curAbbreviation = reader.nextName();
                        break;
                    case SELECTOR_CUR_NAME:
                        curName = reader.nextName();
                        break;
                    case SELECTOR_CUR_QUOT_NAME:
                        curQuotName = reader.nextName();
                        break;
                    default:
                        reader.skipValue();
                        break;
                }
            }
            reader.endObject();
            result.add(new Currency(curId, curParentId, curCode, curAbbreviation, curName, curQuotName));
        }
        reader.endArray();

        return result;
    }
}
