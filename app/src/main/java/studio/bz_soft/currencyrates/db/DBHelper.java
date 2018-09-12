package studio.bz_soft.currencyrates.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import studio.bz_soft.currencyrates.BuildConfig;

public class DBHelper extends SQLiteOpenHelper {

    private final static String TAG = DBHelper.class.getSimpleName();

    private SQLiteDatabase readableDB;
    private SQLiteDatabase writeableDB;
    public String dbValues = "";

    private final static String CREATE_TABLE_CURRENCIES = "CREATE TABLE IF NOT EXISTS `Currencies` " +
            "( `_id` INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "`curID` INTEGER NOT NULL, " +
            "`curParentID` INTEGER NOT NULL, " +
            "`curCode` TEXT NOT NULL, " +
            "`curAbbreviation` TEXT NOT NULL, " +
            "`curName` TEXT NOT NULL, " +
            "`curQuotName` TEXT NOT NULL " +
            ");";

    private final static String CREATE_TABLE_RATES = "CREATE TABLE IF NOT EXISTS `Rates` " +
            "( `_id` INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "`curID` INTEGER NOT NULL, " +
            "`date` TEXT NOT NULL, " +
            "`curAbbreviation` TEXT NOT NULL, " +
            "`curScale` INTEGER NOT NULL, " +
            "`curName` TEXT NOT NULL, " +
            "`curOfficialRate` NUMERIC NOT NULL " +
            ");";

    public final static String SELECT_ALL_FROM_CURRENCIES = "SELECT * FROM `Currencies` ORDER BY _id";
    public final static String SELECT_ALL_FROM_RATES = "SELECT * FROM `Rates` ORDER BY _id";

    public final static String INSERT_INTO_CURRENCIES = "INSERT INTO `Currencies` (`curID`, " +
            "`curParentID`, `curCode`, `curAbbreviation`, `curName`, `curQuotName`) " +
            "VALUES( %s )";
    public final static String INSERT_INTO_RATES = "INSERT INTO `Rates` (`curID`, `date`, " +
            "`curAbbreviation`, `curScale`, `curName`, `curOfficialRate`) " +
            "VALUES( %s )";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     *
     * @param SQL
     * @param object
     * @return
     */
    public Object readQuery(String SQL, Object object) {
        Cursor cursor = null;
        Object entry = new Object();

        try {
            if (readableDB == null) {
                readableDB = getReadableDatabase();
            }
            cursor = readableDB.rawQuery(SQL, null);
            cursor.moveToFirst();
            do {

            } while (cursor.moveToNext());

            // TODO Реализовать чтение любой таблицы в нужный класс и возврат класса как объекта в return
            if (BuildConfig.DEBUG) {
                Log.d(TAG, "--- Read from table: " + cursor.toString());
            }

        } catch (Exception ex) {
            if (BuildConfig.DEBUG) {
                Log.e(TAG, "--- readQuery Exception ---", ex);
            }
        } finally {
            cursor.close();
            return null;
        }
    }

    /**
     *
     * @param tableName
     * @param contentValues
     * @return
     */
    public boolean insertQuery(String tableName, ContentValues contentValues) {
        long result = 0;
        try {
            if (writeableDB == null) {
                writeableDB = getWritableDatabase();
            }
            result = writeableDB.insert(tableName, null, contentValues);
        } catch (Exception ex) {
            if (BuildConfig.DEBUG) {
                Log.e(TAG, "--- insertQuery Exception ---", ex);
            }
        }
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "insertQuery result = " + result);
        }
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

//    public List<User> getUsers() {
//        List<User> userList = new ArrayList<>();
//        Cursor cursor = null;
//        try {
//            if (readableDB == null) {
//                readableDB = getReadableDatabase();
//            }
//            cursor = readableDB.rawQuery(SELECT_ALL_FROM_USER, null);
//            cursor.moveToFirst();
//            do {
//                userList.add(returnUserFromCursor(cursor));
//            } while (cursor.moveToNext());
//            if (BuildConfig.DEBUG) {
//                Log.d(TAG, "--- Read from table: " + cursor.toString());
//            }
//        } catch (Exception ex) {
//            if (BuildConfig.DEBUG) {
//                Log.e(TAG, "--- readQuery Exception ---", ex);
//            }
//        } finally {
//            cursor.close();
//        }
//        return userList;
//    }
//
//    private User returnUserFromCursor(Cursor cursor) {
//        User user = new User();
//        if (cursor != null) {
//            user.setId(cursor.getInt(cursor.getColumnIndex("_id")));
//            user.setName(cursor.getString(cursor.getColumnIndex("Name")));
//            user.setBirthDay(cursor.getString(cursor.getColumnIndex("BirthDay")));
//            user.setSex(cursor.getInt(cursor.getColumnIndex("Sex")));
//            user.setHeight(cursor.getFloat(cursor.getColumnIndex("Height")));
//            user.setCurrentWeight(cursor.getFloat(cursor.getColumnIndex("CurrentWeight")));
//            user.setDesiredWeight(cursor.getFloat(cursor.getColumnIndex("DesiredWeight")));
//        }
//        return user;
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "--- onCreate DB ---");
            Log.d(TAG, "--- create Table Currencies ---");
            Log.d(TAG, "--- create Table Rates ---");
        }
        db.execSQL(CREATE_TABLE_CURRENCIES);
        db.execSQL(CREATE_TABLE_RATES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "--- onUpgrade DB ---");
        }
    }
}
