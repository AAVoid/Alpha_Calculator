package com.aymerikaboso.calculator.activite;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.aymerikaboso.calculator.R;
import com.aymerikaboso.calculator.model.calculus_list_view.CalculusAdapter;
import com.aymerikaboso.calculator.model.calculus_list_view.CalculusListViewItem;
import com.aymerikaboso.calculator.model.catalogue_list_view.CatalogueAdapter;
import com.aymerikaboso.calculator.model.catalogue_list_view.CatalogueListViewItem;

import java.util.ArrayList;

public class Catalogue extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayList<CatalogueListViewItem> listeFonctions = new ArrayList<CatalogueListViewItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);

        //Toolbar et action bar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar2);
        myToolbar.setTitle(getResources().getString(R.string.app_name));
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setSubtitle(Html.fromHtml("<i><font color=#dddddd>"
                + getResources().getString(R.string.sousTitreCatalogue) + "</font></i>"));

        //Mise en place de la ListView
        ListView listeViewCatalogue = (ListView)findViewById(R.id.listeViewCatalogue);

        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_0), getResources().getString(R.string.catalogue_desc_0), getResources().getString(R.string.catalogue_exemple_0)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_1), getResources().getString(R.string.catalogue_desc_1), getResources().getString(R.string.catalogue_exemple_1)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_2), getResources().getString(R.string.catalogue_desc_2), getResources().getString(R.string.catalogue_exemple_2)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_3), getResources().getString(R.string.catalogue_desc_3), getResources().getString(R.string.catalogue_exemple_3)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_4), getResources().getString(R.string.catalogue_desc_4), getResources().getString(R.string.catalogue_exemple_4)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_5), getResources().getString(R.string.catalogue_desc_5), getResources().getString(R.string.catalogue_exemple_5)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_6), getResources().getString(R.string.catalogue_desc_6), getResources().getString(R.string.catalogue_exemple_6)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_7), getResources().getString(R.string.catalogue_desc_7), getResources().getString(R.string.catalogue_exemple_7)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_8), getResources().getString(R.string.catalogue_desc_8), getResources().getString(R.string.catalogue_exemple_8)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_9), getResources().getString(R.string.catalogue_desc_9), getResources().getString(R.string.catalogue_exemple_9)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_factorielle), getResources().getString(R.string.catalogue_desc_factorielle), getResources().getString(R.string.catalogue_exemple_factorielle)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_parenthese_ouvrante), getResources().getString(R.string.catalogue_desc_parenthese_ouvrante), getResources().getString(R.string.catalogue_exemple_parenthese_ouvrante)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_parenthese_fermante), getResources().getString(R.string.catalogue_desc_parenthese_fermante), getResources().getString(R.string.catalogue_exemple_parenthese_fermante)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_virgule), getResources().getString(R.string.catalogue_desc_virgule), getResources().getString(R.string.catalogue_exemple_virgule)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_point), getResources().getString(R.string.catalogue_desc_point), getResources().getString(R.string.catalogue_exemple_point)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_abs), getResources().getString(R.string.catalogue_desc_abs), getResources().getString(R.string.catalogue_exemple_abs)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_plus), getResources().getString(R.string.catalogue_desc_ADDITION), getResources().getString(R.string.catalogue_exemple_ADDITION)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_egal_fonction), getResources().getString(R.string.catalogue_desc_egal_fonction), getResources().getString(R.string.catalogue_exemple_egal_fonction)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_arccos), getResources().getString(R.string.catalogue_desc_arccos), getResources().getString(R.string.catalogue_exemple_arccos)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_arccosech), getResources().getString(R.string.catalogue_desc_arccosech), getResources().getString(R.string.catalogue_exemple_arccosech)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_arccosh), getResources().getString(R.string.catalogue_desc_arccosh), getResources().getString(R.string.catalogue_exemple_arccosh)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_arcctan), getResources().getString(R.string.catalogue_desc_arcctan), getResources().getString(R.string.catalogue_exemple_arcctan)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_arcctanh), getResources().getString(R.string.catalogue_desc_arcctanh), getResources().getString(R.string.catalogue_exemple_arcctanh)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_arcsech), getResources().getString(R.string.catalogue_desc_arcsech), getResources().getString(R.string.catalogue_exemple_arcsech)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_arcsin), getResources().getString(R.string.catalogue_desc_arcsin), getResources().getString(R.string.catalogue_exemple_arcsin)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_arcsinh), getResources().getString(R.string.catalogue_desc_arcsinh), getResources().getString(R.string.catalogue_exemple_arcsinh)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_arctan), getResources().getString(R.string.catalogue_desc_arctan), getResources().getString(R.string.catalogue_exemple_arctan)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_arctanh), getResources().getString(R.string.catalogue_desc_arctanh), getResources().getString(R.string.catalogue_exemple_arctanh)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_C), getResources().getString(R.string.catalogue_desc_C), getResources().getString(R.string.catalogue_exemple_C)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_ceil), getResources().getString(R.string.catalogue_desc_ceil), getResources().getString(R.string.catalogue_exemple_ceil)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_cos), getResources().getString(R.string.catalogue_desc_cos), getResources().getString(R.string.catalogue_exemple_cos)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_cosec), getResources().getString(R.string.catalogue_desc_cosec), getResources().getString(R.string.catalogue_exemple_cosec)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_cosech), getResources().getString(R.string.catalogue_desc_cosech), getResources().getString(R.string.catalogue_exemple_cosech)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_cosh), getResources().getString(R.string.catalogue_desc_cosh), getResources().getString(R.string.catalogue_exemple_cosh)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_ctan), getResources().getString(R.string.catalogue_desc_ctan), getResources().getString(R.string.catalogue_exemple_ctan)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_ctanh), getResources().getString(R.string.catalogue_desc_ctanh), getResources().getString(R.string.catalogue_exemple_ctanh)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_deg), getResources().getString(R.string.catalogue_desc_deg), getResources().getString(R.string.catalogue_exemple_deg)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_diviser), getResources().getString(R.string.catalogue_desc_DIVISION), getResources().getString(R.string.catalogue_exemple_DIVISION)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_exp), getResources().getString(R.string.catalogue_desc_exp), getResources().getString(R.string.catalogue_exemple_exp)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_Fib), getResources().getString(R.string.catalogue_desc_Fib), getResources().getString(R.string.catalogue_exemple_Fib)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_floor), getResources().getString(R.string.catalogue_desc_floor), getResources().getString(R.string.catalogue_exemple_floor)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_gcd), getResources().getString(R.string.catalogue_desc_gcd), getResources().getString(R.string.catalogue_exemple_gcd)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_int), getResources().getString(R.string.catalogue_desc_int), getResources().getString(R.string.catalogue_exemple_int)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_ispr), getResources().getString(R.string.catalogue_desc_ispr), getResources().getString(R.string.catalogue_exemple_ispr)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_lcm), getResources().getString(R.string.catalogue_desc_lcm), getResources().getString(R.string.catalogue_exemple_lcm)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_ln), getResources().getString(R.string.catalogue_desc_ln), getResources().getString(R.string.catalogue_exemple_ln)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_log), getResources().getString(R.string.catalogue_desc_log), getResources().getString(R.string.catalogue_exemple_log)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_log10), getResources().getString(R.string.catalogue_desc_log10), getResources().getString(R.string.catalogue_exemple_log10)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_log2), getResources().getString(R.string.catalogue_desc_log2), getResources().getString(R.string.catalogue_exemple_log2)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_max), getResources().getString(R.string.catalogue_desc_max), getResources().getString(R.string.catalogue_exemple_max)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_mean), getResources().getString(R.string.catalogue_desc_mean), getResources().getString(R.string.catalogue_exemple_mean)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_min), getResources().getString(R.string.catalogue_desc_min), getResources().getString(R.string.catalogue_exemple_min)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_mod), getResources().getString(R.string.catalogue_desc_mod), getResources().getString(R.string.catalogue_exemple_mod)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_diviser), getResources().getString(R.string.catalogue_desc_MOINS), getResources().getString(R.string.catalogue_exemple_MOINS)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_multiplier), getResources().getString(R.string.catalogue_desc_MULTIPLICATION), getResources().getString(R.string.catalogue_exemple_MULTIPLICATION)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_pi), getResources().getString(R.string.catalogue_desc_pi), getResources().getString(R.string.catalogue_exemple_pi)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_puissance), getResources().getString(R.string.catalogue_desc_PUISSANCE), getResources().getString(R.string.catalogue_exemple_PUISSANCE)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_rad), getResources().getString(R.string.catalogue_desc_rad), getResources().getString(R.string.catalogue_exemple_rad)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_sec), getResources().getString(R.string.catalogue_desc_sec), getResources().getString(R.string.catalogue_exemple_sec)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_sech), getResources().getString(R.string.catalogue_desc_sech), getResources().getString(R.string.catalogue_exemple_sech)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_sin), getResources().getString(R.string.catalogue_desc_sin), getResources().getString(R.string.catalogue_exemple_sin)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_sinh), getResources().getString(R.string.catalogue_desc_sinh), getResources().getString(R.string.catalogue_exemple_sinh)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_solve), getResources().getString(R.string.catalogue_desc_solve), getResources().getString(R.string.catalogue_exemple_solve)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_sqrt), getResources().getString(R.string.catalogue_desc_sqrt), getResources().getString(R.string.catalogue_exemple_sqrt)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_tan), getResources().getString(R.string.catalogue_desc_tan), getResources().getString(R.string.catalogue_exemple_tan)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_tanh), getResources().getString(R.string.catalogue_desc_tanh), getResources().getString(R.string.catalogue_exemple_tanh)));
        listeFonctions.add(new CatalogueListViewItem(getResources().getString(R.string.bouton_x), getResources().getString(R.string.catalogue_desc_x), getResources().getString(R.string.catalogue_exemple_x)));
        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        CatalogueAdapter matchingCatalogue = new CatalogueAdapter(listeFonctions, getApplicationContext());

        listeViewCatalogue.setAdapter(matchingCatalogue);
        matchingCatalogue.notifyDataSetChanged();
        listeViewCatalogue.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //On recrée la text view de façon à récupérer le texte sans les balises HTML
        TextView nettoyageHTMLChaine = new TextView(this);
        nettoyageHTMLChaine.setText(Html.fromHtml(listeFonctions.get(i).getFonction()));
        String fonctionRecuperee = nettoyageHTMLChaine.getText().toString();
        //On retourne à la calculatrice
        Intent intentMainActivity = new Intent(this, MainActivity.class);
        intentMainActivity.putExtra("FONCTION_A_RECUPERER", fonctionRecuperee);
        startActivity(intentMainActivity);
        //Son chargement catalogue
        MediaPlayer mediaPlayerChargementCatalogue = MediaPlayer.create(getApplicationContext(), R.raw.son_chargement_catalogue);
        mediaPlayerChargementCatalogue.start();
    }
}
