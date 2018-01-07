package com.aymerikaboso.calculator.activite;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aymerikaboso.calculator.R;
import com.aymerikaboso.calculator.model.calculus_list_view.CalculusAdapter;
import com.aymerikaboso.calculator.model.calculus_list_view.CalculusListViewItem;
import com.aymerikaboso.calculator.model.donnee.CalculusListViewItem_DAO;

import java.util.ArrayList;

public class Historique extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayList<CalculusListViewItem> listeCalculs = new ArrayList<CalculusListViewItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);

        //Toolbar et action bar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar2);
        myToolbar.setTitle(getResources().getString(R.string.app_name));
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setSubtitle(Html.fromHtml("<i><font color=#dddddd>"
                + getResources().getString(R.string.sousTitreHistorique) + "</font></i>"));

        //Mise en place de la ListView
        ListView listeViewHistorique = (ListView)findViewById(R.id.listeViewHisto);

        //On récupère l'historique en base
        CalculusListViewItem_DAO daoCalculHisto = new CalculusListViewItem_DAO(this);
        daoCalculHisto.open();
        listeCalculs = daoCalculHisto.getAllCalculus();
        daoCalculHisto.close();

        CalculusAdapter matchingHistorique = new CalculusAdapter(listeCalculs, getApplicationContext());
        /*ArrayAdapter matchingHistorique =
                new ArrayAdapter(this,
                        //android.R.layout.browser_link_context_header, listeCalculs);
                        //android.R.layout.preference_category, listeCalculs);
                        //android.R.layout.select_dialog_item, listeCalculs);
                        //android.R.layout.simple_dropdown_item_1line, listeCalculs);
                        android.R.layout.simple_expandable_list_item_1, listeCalculs);
                        //android.R.layout.simple_expandable_list_item_2, listeCalculs);
                        //android.R.layout.simple_gallery_item, listeCalculs);
                        //android.R.layout.simple_list_item_1, listeCalculs);
                        //android.R.layout.simple_list_item_2, listeCalculs);
                        //android.R.layout.simple_list_item_activated_1, listeCalculs);
                        //android.R.layout.simple_list_item_activated_2, listeCalculs);
                        //android.R.layout.simple_list_item_checked, listeCalculs);
                        //android.R.layout.simple_list_item_multiple_choice, listeCalculs);
                        //android.R.layout.simple_list_item_single_choice, listeCalculs);
                        //android.R.layout.simple_selectable_list_item, listeCalculs);
                        //android.R.layout.simple_spinner_dropdown_item, listeCalculs);
                        //android.R.layout.simple_spinner_item, listeCalculs);
                        //android.R.layout.test_list_item, listeCalculs);
                        //android.R.layout.two_line_list_item, listeCalculs);*/

        listeViewHistorique.setAdapter(matchingHistorique);
        matchingHistorique.notifyDataSetChanged();
        listeViewHistorique.setOnItemClickListener(this);

        //On se place à la fin de l'historique pour que l'utilisateur aient
        //les calculs les plus récents
        listeViewHistorique.setSelection(listeCalculs.size());
    }

    //POUR L'ACTION BAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menu_historique, menu);
        return true;
    }

    //POUR L'ACTION BAR
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.MenuItemDelHisto) {
            String COULEUR_TEXTE_BOUTONS = "#00b0f0";
            if(!this.listeCalculs.isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                //builder.setTitle("Confirm Exit..!!!");
                //builder.setIcon(R.drawable.question);
                builder.setMessage(R.string.texte_confirmation_effacer_historique);
                builder.setCancelable(false);
                builder.setPositiveButton(R.string.texte_confirmation_effacer_historique_oui, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Context context = getApplicationContext();
                        CalculusListViewItem_DAO daoCalculHisto = new CalculusListViewItem_DAO(context);
                        daoCalculHisto.open();
                        daoCalculHisto.removeAllCalculus();
                        daoCalculHisto.close();
                        //On retourne à la calculatrice
                        Intent intentMainActivity = new Intent(context, MainActivity.class);
                        startActivity(intentMainActivity);
                        //Son effacement historique
                        MediaPlayer mediaPlayerEffacerHisto = MediaPlayer.create(getApplicationContext(), R.raw.son_effacer_histo);
                        mediaPlayerEffacerHisto.start();
                        Toast.makeText(getApplicationContext(),
                                R.string.texte_confirmation_effacer_historique_toast, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton(R.string.texte_confirmation_effacer_historique_non, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
                dialog.getButton(dialog.BUTTON_POSITIVE).setTextColor(Color.parseColor(COULEUR_TEXTE_BOUTONS));
                dialog.getButton(dialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor(COULEUR_TEXTE_BOUTONS));
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    //Appuie sur un item de la liste
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //On recrée la text view de façon à récupérer le texte sans les balises HTML
        TextView nettoyageHTMLChaine = new TextView(this);
        nettoyageHTMLChaine.setText(Html.fromHtml(listeCalculs.get(i).getCalcul()));
        String calculRecupere = nettoyageHTMLChaine.getText().toString();
        //On retourne à la calculatrice
        Intent intentMainActivity = new Intent(this, MainActivity.class);
        intentMainActivity.putExtra("CALCUL_A_RECUPERER", calculRecupere);
        startActivity(intentMainActivity);
        //Son chargement historique
        MediaPlayer mediaPlayerChargementHisto = MediaPlayer.create(getApplicationContext(), R.raw.son_chargement_histo);
        mediaPlayerChargementHisto.start();
    }
}
