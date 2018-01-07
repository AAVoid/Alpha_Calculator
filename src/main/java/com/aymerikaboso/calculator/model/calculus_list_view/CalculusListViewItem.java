package com.aymerikaboso.calculator.model.calculus_list_view;

/**
 * Created by CFAPAG on 04/12/2017.
 */

public class CalculusListViewItem {
    private int id; //Pour la base de donnée SQLite
    private String calcul;
    private String resultat;

    public CalculusListViewItem(String calcul, String resultat) {
        this.calcul = calcul;
        this.resultat = resultat;
    }

    public String getCalcul() {
        return calcul;
    }

    public void setCalcul(String calcul) {
        this.calcul = calcul;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    @Override
    public String toString() {
        return "CalculusListViewItem{" +
                "id=" + id +
                ", calcul='" + calcul + '\'' +
                '}';
    }
}
