package com.aymerikaboso.calculator.activite;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.aymerikaboso.calculator.R;

public class InformationApplication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_application);

        //Toolbar et action bar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar3);
        myToolbar.setTitle(getResources().getString(R.string.app_name));
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setSubtitle(Html.fromHtml("<i><font color=#dddddd>"
                + getResources().getString(R.string.sousTitreInformation) + "</font></i>"));

        TextView texte = findViewById(R.id.textView);
        texte.setMovementMethod(new ScrollingMovementMethod()); //Pour pouvoir scroller
        String texteHTML = getResources().getString(R.string.texte_information_application);
        texteHTML = finaliserTexte(texteHTML);
        texte.setText(Html.fromHtml(texteHTML));
    }

    private String finaliserTexte(String texteRessource) {
        texteRessource = texteRessource.replace("__00", "<font color=\"black\"><i>");
        texteRessource = texteRessource.replace("__01", "<br>");
        texteRessource = texteRessource.replace("__02", "</i></font>");
        texteRessource = texteRessource.replace("__03", "<font color=\"blue\"><i>");
        texteRessource = texteRessource.replace("__04", "<font color=#3f51b5>");
        texteRessource = texteRessource.replace("__05", "</font>");
        texteRessource = texteRessource.replace("__06", "<font color=#00b0f0><i>");
        texteRessource = texteRessource.replace("__07", "</i></font>");
        texteRessource = texteRessource.replace("__08", "<font color=#f4a442><i>");
        texteRessource = texteRessource.replace("__09", "</i></font>");

        return texteRessource;
    }
}
