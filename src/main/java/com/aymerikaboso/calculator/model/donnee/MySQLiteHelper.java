package com.aymerikaboso.calculator.model.donnee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by CFAPAG on 05/12/2017.
 */


//https://www.androidhive.info/2013/09/android-sqlite-database-with-multiple-tables/
public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String NOM_BDD = "AlphaData.db";

    public static final String NOM_TABLE_HISTORIQUE = "historique";
    public static final String HISTORIQUE_COL_ID = "id";
    public static final String HISTORIQUE_COL_CALCUL = "calcul";
    public static final String HISTORIQUE_COL_RESULTAT = "resultat";

    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //On crée toutes les tables
        String requete1 = "CREATE TABLE " + NOM_TABLE_HISTORIQUE + "(" + HISTORIQUE_COL_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + HISTORIQUE_COL_CALCUL + " TEXT, " +
                HISTORIQUE_COL_RESULTAT + " TEXT);";
        sqLiteDatabase.execSQL(requete1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Il faut droper toutes les tables
        String requete1 = "DROP TABLE IF EXISTS " + NOM_TABLE_HISTORIQUE + ";";
        sqLiteDatabase.execSQL(requete1);
        onCreate(sqLiteDatabase);
    }
}
