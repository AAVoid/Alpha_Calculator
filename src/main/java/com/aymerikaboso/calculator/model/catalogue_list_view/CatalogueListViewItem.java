package com.aymerikaboso.calculator.model.catalogue_list_view;

/**
 * Created by CFAPAG on 31/12/2017.
 */

public class CatalogueListViewItem {
    private String fonction;
    private String description;
    private String exemple;

    public CatalogueListViewItem(String fonction, String description, String exemple) {
        this.fonction = fonction;
        this.description = description;
        this.exemple = exemple;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExemple() {
        return exemple;
    }

    public void setExemple(String exemple) {
        this.exemple = exemple;
    }
}
