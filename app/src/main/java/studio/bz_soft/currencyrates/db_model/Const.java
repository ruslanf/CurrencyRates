package studio.bz_soft.currencyrates.db_model;

final class Const {

    static final String DB_NAME = "currency_database";

    final static String CREATE_TABLE_CURRENCIES = "CREATE TABLE IF NOT EXISTS `Currencies` " +
            "( `_id` INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "`curID` INTEGER NOT NULL, " +
            "`curParentID` INTEGER NOT NULL, " +
            "`curCode` TEXT NOT NULL, " +
            "`curAbbreviation` TEXT NOT NULL, " +
            "`curName` TEXT NOT NULL, " +
            "`curQuotName` TEXT NOT NULL " +
            ");";

    final static String CREATE_TABLE_RATES = "CREATE TABLE IF NOT EXISTS `Rates` " +
            "( `_id` INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "`curID` INTEGER NOT NULL, " +
            "`date` TEXT NOT NULL, " +
            "`curAbbreviation` TEXT NOT NULL, " +
            "`curScale` INTEGER NOT NULL, " +
            "`curName` TEXT NOT NULL, " +
            "`curOfficialRate` NUMERIC NOT NULL " +
            ");";

}
