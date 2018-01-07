package com.aymerikaboso.calculator.model.donnee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.aymerikaboso.calculator.model.calculus_list_view.CalculusListViewItem;
import com.aymerikaboso.calculator.model.colortext.ColorText;

import java.util.ArrayList;

/**
 * Created by CFAPAG on 07/12/2017.
 */

//https://www.androidhive.info/2013/09/android-sqlite-database-with-multiple-tables/
public class CalculusListViewItem_DAO {
    private SQLiteDatabase bdd;
    private MySQLiteHelper maBaseSQLite;

    public CalculusListViewItem_DAO(Context context){
        //On crée la BDD et sa table
        maBaseSQLite = new MySQLiteHelper(context, MySQLiteHelper.NOM_BDD, null, MySQLiteHelper.DATABASE_VERSION);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    //Renvoie le nombre de lignes de la table après l'ajout
    public long insertCalculus(CalculusListViewItem calcul){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(MySQLiteHelper.HISTORIQUE_COL_CALCUL, calcul.getCalcul());
        values.put(MySQLiteHelper.HISTORIQUE_COL_RESULTAT, calcul.getResultat());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(MySQLiteHelper.NOM_TABLE_HISTORIQUE, null, values);
    }

    //Renvoie le nombre de lignes supprimées
    public int removeAllCalculus(){
        //Suppression d'un livre de la BDD grâce à l'ID
        return bdd.delete(MySQLiteHelper.NOM_TABLE_HISTORIQUE, "1", null);
    }

    public ArrayList<CalculusListViewItem> getAllCalculus(){
        ArrayList<CalculusListViewItem> liste = new ArrayList<CalculusListViewItem>();
        String requete = "SELECT * FROM " + MySQLiteHelper.NOM_TABLE_HISTORIQUE + ";";
        Cursor c = bdd.rawQuery(requete, null);
        /*Cursor c = bdd.query(MySQLiteHelper.NOM_TABLE_HISTORIQUE, new String[] {MySQLiteHelper.HISTORIQUE_COL_ID,
            MySQLiteHelper.HISTORIQUE_COL_CALCUL}, "1", null, null, null, null);*/
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                CalculusListViewItem calcul = new CalculusListViewItem("", "");
                calcul.setId(c.getInt((c.getColumnIndex(MySQLiteHelper.HISTORIQUE_COL_ID))));
                calcul.setCalcul(c.getString(c.getColumnIndex(MySQLiteHelper.HISTORIQUE_COL_CALCUL)));
                calcul.setResultat(c.getString(c.getColumnIndex(MySQLiteHelper.HISTORIQUE_COL_RESULTAT)));
                //Log.v("loadCalc", calcul.toString());
                liste.add(calcul);
            } while (c.moveToNext());
        }
        return liste;
    }
}
