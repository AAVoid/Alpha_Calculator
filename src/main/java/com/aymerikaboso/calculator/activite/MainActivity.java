package com.aymerikaboso.calculator.activite;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aymerikaboso.calculator.R;
import com.aymerikaboso.calculator.model.calculus_list_view.CalculusListViewItem;
import com.aymerikaboso.calculator.model.colortext.ColorText;
import com.aymerikaboso.calculator.model.donnee.CalculusListViewItem_DAO;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static String CALCUL_STRING = ""; //Pour mémoriser la saisie en cas d'exécution de onCreate
    private static double ANCIEN_RESULTAT = 0d;
    private int sousClavierNumero; //Numéro du sous clavier dynamique actuel
    private static final int SOUS_CLAVIER_NUMERO_MAX = 11; //Nombre de sous claviers dynamiques
    private ArrayList<String> listeStringBouton35;
    private ArrayList<String> listeStringBouton32;
    private ArrayList<String> listeStringBouton28;
    private ArrayList<String> listeStringBouton24;
    private ArrayList<String> listeStringBouton9;

    //SONS DIVERS
    private MediaPlayer mediaPlayerCalcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int orientation = getResources().getConfiguration().orientation;
        //Initialisation boutons clavier dynamique
        this.sousClavierNumero = 1; //La clavier dynamique commence au niveau 1
        //Initialisation boutons clavier dynamique
        this.listeStringBouton35 = new ArrayList<String>();
        this.listeStringBouton35.add(getResources().getString(R.string.bouton_plus));
        this.listeStringBouton35.add(getResources().getString(R.string.bouton_virgule));
        this.listeStringBouton35.add(getResources().getString(R.string.bouton_abs)); //3
        this.listeStringBouton35.add(getResources().getString(R.string.bouton_tan));
        this.listeStringBouton35.add(getResources().getString(R.string.bouton_ln));
        this.listeStringBouton35.add(getResources().getString(R.string.bouton_log)); //6
        this.listeStringBouton35.add(getResources().getString(R.string.bouton_min));
        this.listeStringBouton35.add(getResources().getString(R.string.bouton_sec));
        this.listeStringBouton35.add(getResources().getString(R.string.bouton_ctanh)); //9
        this.listeStringBouton35.add(getResources().getString(R.string.bouton_arcsech));
        this.listeStringBouton35.add(getResources().getString(R.string.bouton_egal_fonction)); //11

        this.listeStringBouton32 = new ArrayList<String>();
        this.listeStringBouton32.add(getResources().getString(R.string.bouton_moins));
        this.listeStringBouton32.add(getResources().getString(R.string.bouton_pi));
        this.listeStringBouton32.add(getResources().getString(R.string.bouton_mod)); //3
        this.listeStringBouton32.add(getResources().getString(R.string.bouton_sin));
        this.listeStringBouton32.add(getResources().getString(R.string.bouton_exp));
        this.listeStringBouton32.add(getResources().getString(R.string.bouton_lcm)); //6
        this.listeStringBouton32.add(getResources().getString(R.string.bouton_mean));
        this.listeStringBouton32.add(getResources().getString(R.string.bouton_tanh));
        this.listeStringBouton32.add(getResources().getString(R.string.bouton_ctan)); //9
        this.listeStringBouton32.add(getResources().getString(R.string.bouton_arccosech));
        this.listeStringBouton32.add(getResources().getString(R.string.bouton_x)); //11

        this.listeStringBouton28 = new ArrayList<String>();
        this.listeStringBouton28.add(getResources().getString(R.string.bouton_multiplier));
        this.listeStringBouton28.add(getResources().getString(R.string.bouton_factorielle));
        this.listeStringBouton28.add(getResources().getString(R.string.bouton_floor)); //3
        this.listeStringBouton28.add(getResources().getString(R.string.bouton_cos));
        this.listeStringBouton28.add(getResources().getString(R.string.bouton_arctan));
        this.listeStringBouton28.add(getResources().getString(R.string.bouton_gcd)); //6
        this.listeStringBouton28.add(getResources().getString(R.string.bouton_max));
        this.listeStringBouton28.add(getResources().getString(R.string.bouton_sinh));
        this.listeStringBouton28.add(getResources().getString(R.string.bouton_sech)); //9
        this.listeStringBouton28.add(getResources().getString(R.string.bouton_arctanh));
        this.listeStringBouton28.add(getResources().getString(R.string.bouton_solve)); //11

        this.listeStringBouton24 = new ArrayList<String>();
        this.listeStringBouton24.add(getResources().getString(R.string.bouton_diviser));
        this.listeStringBouton24.add(getResources().getString(R.string.bouton_parenthese_fermante));
        this.listeStringBouton24.add(getResources().getString(R.string.bouton_ceil)); //3
        this.listeStringBouton24.add(getResources().getString(R.string.bouton_rad));
        this.listeStringBouton24.add(getResources().getString(R.string.bouton_arcsin));
        this.listeStringBouton24.add(getResources().getString(R.string.bouton_sqrt)); //6
        this.listeStringBouton24.add(getResources().getString(R.string.bouton_log2));
        this.listeStringBouton24.add(getResources().getString(R.string.bouton_cosh));
        this.listeStringBouton24.add(getResources().getString(R.string.bouton_cosech)); //9
        this.listeStringBouton24.add(getResources().getString(R.string.bouton_arcsinh));
        this.listeStringBouton24.add(getResources().getString(R.string.bouton_int)); //11

        this.listeStringBouton9 = new ArrayList<String>();
        this.listeStringBouton9.add(getResources().getString(R.string.bouton_puissance));
        this.listeStringBouton9.add(getResources().getString(R.string.bouton_parenthese_ouvrante));
        this.listeStringBouton9.add(getResources().getString(R.string.bouton_ispr)); //3
        this.listeStringBouton9.add(getResources().getString(R.string.bouton_deg));
        this.listeStringBouton9.add(getResources().getString(R.string.bouton_arccos));
        this.listeStringBouton9.add(getResources().getString(R.string.bouton_Fib)); //6
        this.listeStringBouton9.add(getResources().getString(R.string.bouton_log10));
        this.listeStringBouton9.add(getResources().getString(R.string.bouton_C));
        this.listeStringBouton9.add(getResources().getString(R.string.bouton_cosec)); //9
        this.listeStringBouton9.add(getResources().getString(R.string.bouton_arccosh));
        this.listeStringBouton9.add(getResources().getString(R.string.bouton_arcctanh)); //11

        //Toolbar et action bar
        if (orientation == Configuration.ORIENTATION_PORTRAIT) { //PORTRAIT
            Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
            myToolbar.setTitle(getResources().getString(R.string.app_name));
            myToolbar.setTitleTextColor(Color.WHITE);
            setSupportActionBar(myToolbar);
            getSupportActionBar().setSubtitle(Html.fromHtml("<i><font color=#dddddd>"
                    + getResources().getString(R.string.sousTitreCalculatrice) + "</font></i>"));
        }

        //Restauration de la zone d'affichage (cas changement de layout)
        TextView zoneAffichage = findViewById(R.id.textView4);
        zoneAffichage.setMovementMethod(new ScrollingMovementMethod()); //Pour pouvoir scroller
        //On récupère le calcul de l'historique éventuellement
        Intent intentActuelle = getIntent();
        String calculRecupHisto = intentActuelle.getStringExtra("CALCUL_A_RECUPERER");
        intentActuelle.removeExtra("CALCUL_A_RECUPERER"); //On supprime l'extra pour éviter tout sur ajout
        //lors de la rotation - rechargement de l'activité
        if(calculRecupHisto != null)
            MainActivity.CALCUL_STRING = calculRecupHisto;
        //On récupère la fonction du catalogue éventuellement
        String fonctionRecupCatalogue = intentActuelle.getStringExtra("FONCTION_A_RECUPERER");
        intentActuelle.removeExtra("FONCTION_A_RECUPERER"); //On supprime l'extra pour éviter tout sur ajout
        //lors de la rotation - rechargement de l'activité
        if(fonctionRecupCatalogue != null)
            MainActivity.CALCUL_STRING += fonctionRecupCatalogue;

        MainActivity.CALCUL_STRING = ColorText.colorierCalcule(this, MainActivity.CALCUL_STRING);
        zoneAffichage.setText(Html.fromHtml(MainActivity.CALCUL_STRING));

        //Ecouteurs
        /*On test l'orientation de l'écran pour s'assurer qu'on met bien un écouteur sur le bon élément
        et que chaque élément existe dans le bon contexte*/
        if (orientation == Configuration.ORIENTATION_PORTRAIT) { //PORTRAIT
            Button bouton0 = findViewById(R.id.button34);
            bouton0.setOnClickListener(this);

            Button bouton1 = findViewById(R.id.button29);
            bouton1.setOnClickListener(this);

            Button bouton2 = findViewById(R.id.button30);
            bouton2.setOnClickListener(this);

            Button bouton3 = findViewById(R.id.button31);
            bouton3.setOnClickListener(this);

            Button bouton4 = findViewById(R.id.button25);
            bouton4.setOnClickListener(this);

            Button bouton5 = findViewById(R.id.button26);
            bouton5.setOnClickListener(this);

            Button bouton6 = findViewById(R.id.button27);
            bouton6.setOnClickListener(this);

            Button bouton7 = findViewById(R.id.button21);
            bouton7.setOnClickListener(this);

            Button bouton8 = findViewById(R.id.button22);
            bouton8.setOnClickListener(this);

            Button bouton9 = findViewById(R.id.button23);
            bouton9.setOnClickListener(this);

            Button boutonPoint = findViewById(R.id.button33);
            boutonPoint.setOnClickListener(this);

            Button boutonPlus = findViewById(R.id.button35);
            boutonPlus.setOnClickListener(this);
            boutonPlus.setText(this.listeStringBouton35.get(this.sousClavierNumero - 1));

            Button boutonEgal = findViewById(R.id.button36);
            boutonEgal.setOnClickListener(this);

            Button boutonMoins = findViewById(R.id.button32);
            boutonMoins.setOnClickListener(this);
            boutonMoins.setText(this.listeStringBouton32.get(this.sousClavierNumero - 1));

            Button boutonMultiplier = findViewById(R.id.button28);
            boutonMultiplier.setOnClickListener(this);
            boutonMultiplier.setText(this.listeStringBouton28.get(this.sousClavierNumero - 1));

            Button boutonDiviser = findViewById(R.id.button24);
            boutonDiviser.setOnClickListener(this);
            boutonDiviser.setText(this.listeStringBouton24.get(this.sousClavierNumero - 1));

            Button boutonC = findViewById(R.id.button14);
            boutonC.setOnClickListener(this);

            Button boutonA = findViewById(R.id.button15);
            boutonA.setOnClickListener(this);

            Button boutonEffacerCaractere = findViewById(R.id.button37);
            boutonEffacerCaractere.setOnClickListener(this);

            Button boutonPuissance = findViewById(R.id.button9);
            boutonPuissance.setOnClickListener(this);
            boutonPuissance.setText(this.listeStringBouton9.get(this.sousClavierNumero - 1));
        }
        else if (orientation == Configuration.ORIENTATION_LANDSCAPE){ //PAYSAGE
            Button bouton0 = findViewById(R.id.button34);
            bouton0.setOnClickListener(this);

            Button bouton1 = findViewById(R.id.button29);
            bouton1.setOnClickListener(this);

            Button bouton2 = findViewById(R.id.button30);
            bouton2.setOnClickListener(this);

            Button bouton3 = findViewById(R.id.button31);
            bouton3.setOnClickListener(this);

            Button bouton4 = findViewById(R.id.button25);
            bouton4.setOnClickListener(this);

            Button bouton5 = findViewById(R.id.button26);
            bouton5.setOnClickListener(this);

            Button bouton6 = findViewById(R.id.button27);
            bouton6.setOnClickListener(this);

            Button bouton7 = findViewById(R.id.button21);
            bouton7.setOnClickListener(this);

            Button bouton8 = findViewById(R.id.button22);
            bouton8.setOnClickListener(this);

            Button bouton9 = findViewById(R.id.button23);
            bouton9.setOnClickListener(this);

            Button boutonPoint = findViewById(R.id.button33);
            boutonPoint.setOnClickListener(this);

            Button boutonPlus = findViewById(R.id.button35);
            boutonPlus.setOnClickListener(this);
            boutonPlus.setText(this.listeStringBouton35.get(this.sousClavierNumero - 1));

            Button boutonEgal = findViewById(R.id.button36);
            boutonEgal.setOnClickListener(this);

            Button boutonMoins = findViewById(R.id.button32);
            boutonMoins.setOnClickListener(this);
            boutonMoins.setText(this.listeStringBouton32.get(this.sousClavierNumero - 1));

            Button boutonMultiplier = findViewById(R.id.button28);
            boutonMultiplier.setOnClickListener(this);
            boutonMultiplier.setText(this.listeStringBouton28.get(this.sousClavierNumero - 1));

            Button boutonDiviser = findViewById(R.id.button24);
            boutonDiviser.setOnClickListener(this);
            boutonDiviser.setText(this.listeStringBouton24.get(this.sousClavierNumero - 1));

            Button boutonC = findViewById(R.id.button14);
            boutonC.setOnClickListener(this);

            Button boutonA = findViewById(R.id.button15);
            boutonA.setOnClickListener(this);

            Button boutonEffacerCaractere = findViewById(R.id.button37);
            boutonEffacerCaractere.setOnClickListener(this);

            Button boutonPuissance = findViewById(R.id.button9);
            boutonPuissance.setOnClickListener(this);
            boutonPuissance.setText(this.listeStringBouton9.get(this.sousClavierNumero - 1));

            Button boutonFonctions = findViewById(R.id.button39);
            boutonFonctions.setOnClickListener(this);

            Button boutonHisto = findViewById(R.id.button47);
            boutonHisto.setOnClickListener(this);

            Button boutonInfo = findViewById(R.id.button54);
            boutonInfo.setOnClickListener(this);

            Button boutonSousClavierMoins = findViewById(R.id.button61);
            boutonSousClavierMoins.setOnClickListener(this);
            boutonSousClavierMoins.setText("< " + this.sousClavierNumero);

            Button boutonSousClavierPlus = findViewById(R.id.button68);
            boutonSousClavierPlus.setOnClickListener(this);
            boutonSousClavierPlus.setText("" + this.sousClavierNumero + " >");
        }

        //Chargement des sons
        this.mediaPlayerCalcul = MediaPlayer.create(this, R.raw.son_calcul);
    }

    //POUR L'ACTION BAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //POUR L'ACTION BAR
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.MenuItemInfoAppli) { //INFORMATION APPLICATION
            Intent intentInfoAppli = new Intent(this, InformationApplication.class);
            startActivity(intentInfoAppli);
            return true;
        }
        else if(item.getItemId() == R.id.MenuItemHistorique) { //HISTORIQUE
            Intent intentHistorique = new Intent(this, Historique.class);
            startActivity(intentHistorique);
            return true;
        }
        else if(item.getItemId() == R.id.MenuItemCatalogue) { //CATALOGUE
            Intent intentCatalogue = new Intent(this, Catalogue.class);
            startActivity(intentCatalogue);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Pour ajouter une chaîne de caractères à la zone de saisie et la colorier en conséquence
    //Rajoute aussi le précalcul après cette chaîne
    private void ajouterChaineZoneAffichage(TextView zoneAffichage, String s) {
        zoneAffichage.append(s);
        MainActivity.CALCUL_STRING = zoneAffichage.getText().toString();
        MainActivity.CALCUL_STRING = ColorText.colorierCalcule(this, MainActivity.CALCUL_STRING);
        zoneAffichage.setText(Html.fromHtml(MainActivity.CALCUL_STRING));
    }

    //Effacement de la zone d'affichage
    private void effacerZoneAffichage(TextView zoneAffichage) {
        zoneAffichage.setText("");
        MainActivity.CALCUL_STRING = zoneAffichage.getText().toString();
    }

    //Pour pouvoir effacer la zone d'affichage si elle contient Nan et que l'utilisateur
    //appuie sur un bouton
    private void verifierEffacerZoneAffichageNan(TextView zoneAffichage) {
        if(zoneAffichage.getText().toString().equals("NaN")) { //Si pas d'erreur de calcule
            effacerZoneAffichage(zoneAffichage);
        }
    }

    //Contrôler pour éviter deux caractères / chaines identiques à la suite (ex. 2 points, 2 puissances, ...)
    //Renvoie vrai si le dernier (la fin) caractère / chaine de la zone d'affichage est égal à s, faux sinon
    private boolean controlerDeuxCharsIdentiques(TextView zoneAffichage, String s) {
        return zoneAffichage.getText().toString().endsWith(s);
    }

    //ECOUTEUR BOUTONS
    public void onClick(View v) {
        TextView zoneAffichage = findViewById(R.id.textView4);

        if(v.getId() == R.id.button34) {
            //Log.v("INFO", "0");
            verifierEffacerZoneAffichageNan(zoneAffichage);
            ajouterChaineZoneAffichage(zoneAffichage, getResources().getString(R.string.bouton_0));
        }
        else if(v.getId() == R.id.button29) {
            //Log.v("INFO", "1");
            verifierEffacerZoneAffichageNan(zoneAffichage);
            ajouterChaineZoneAffichage(zoneAffichage, getResources().getString(R.string.bouton_1));
        }
        else if(v.getId() == R.id.button30) {
            //Log.v("INFO", "2");
            verifierEffacerZoneAffichageNan(zoneAffichage);
            ajouterChaineZoneAffichage(zoneAffichage, getResources().getString(R.string.bouton_2));
        }
        else if(v.getId() == R.id.button31) {
            //Log.v("INFO", "3");
            verifierEffacerZoneAffichageNan(zoneAffichage);
            ajouterChaineZoneAffichage(zoneAffichage, getResources().getString(R.string.bouton_3));
        }
        else if(v.getId() == R.id.button25) {
            //Log.v("INFO", "4");
            verifierEffacerZoneAffichageNan(zoneAffichage);
            ajouterChaineZoneAffichage(zoneAffichage, getResources().getString(R.string.bouton_4));
        }
        else if(v.getId() == R.id.button26) {
            //Log.v("INFO", "5");
            verifierEffacerZoneAffichageNan(zoneAffichage);
            ajouterChaineZoneAffichage(zoneAffichage, getResources().getString(R.string.bouton_5));
        }
        else if(v.getId() == R.id.button27) {
            //Log.v("INFO", "6");
            verifierEffacerZoneAffichageNan(zoneAffichage);
            ajouterChaineZoneAffichage(zoneAffichage, getResources().getString(R.string.bouton_6));
        }
        else if(v.getId() == R.id.button21) {
            //Log.v("INFO", "7");
            verifierEffacerZoneAffichageNan(zoneAffichage);
            ajouterChaineZoneAffichage(zoneAffichage, getResources().getString(R.string.bouton_7));
        }
        else if(v.getId() == R.id.button22) {
            //Log.v("INFO", "8");
            verifierEffacerZoneAffichageNan(zoneAffichage);
            ajouterChaineZoneAffichage(zoneAffichage, getResources().getString(R.string.bouton_8));
        }
        else if(v.getId() == R.id.button23) {
            //Log.v("INFO", "9");
            verifierEffacerZoneAffichageNan(zoneAffichage);
            ajouterChaineZoneAffichage(zoneAffichage, getResources().getString(R.string.bouton_9));
        }

        else if(v.getId() == R.id.button33) {
            //Log.v("INFO", ".");
            verifierEffacerZoneAffichageNan(zoneAffichage);
            if(!controlerDeuxCharsIdentiques(zoneAffichage, "."))
                ajouterChaineZoneAffichage(zoneAffichage, getResources().getString(R.string.bouton_point));
        }
        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        else if(v.getId() == R.id.button36) { //CALCUL ET ENREGISTREMENT DANS L'HISTORIQUE
            //Log.v("INFO", "=");
            if(!MainActivity.CALCUL_STRING.isEmpty()) {
                //LECTURE SON CALCUL
                this.mediaPlayerCalcul.start();
                //RESULTAT
                MainActivity.CALCUL_STRING = zoneAffichage.getText().toString();
                //Couper la chaîne pour éliminer le précalcul
                //...
                String calculSav = MainActivity.CALCUL_STRING;
                MainActivity.CALCUL_STRING = MainActivity.CALCUL_STRING.replace('×', '*');
                MainActivity.CALCUL_STRING = MainActivity.CALCUL_STRING.replace('÷', '/');
                Expression e = new Expression(MainActivity.CALCUL_STRING);
                String resultatCALCUL_STRING = "" + e.calculate();
                double resultatCalculDouble = e.calculate();
                zoneAffichage.setText(Html.fromHtml(ColorText.colorierCalcule(this, resultatCALCUL_STRING)));
                MainActivity.CALCUL_STRING = zoneAffichage.getText().toString();
                MainActivity.CALCUL_STRING = ColorText.colorierCalcule(this, MainActivity.CALCUL_STRING);

                if(!zoneAffichage.getText().toString().equals("NaN")) { //Si pas d'erreur de calcule
                    //Log.v("!", "NaN");
                    MainActivity.ANCIEN_RESULTAT = resultatCalculDouble;
                }

                //HISTORIQUE
                CalculusListViewItem_DAO daoCalculHisto = new CalculusListViewItem_DAO(this);
                daoCalculHisto.open();
                CalculusListViewItem calculAAjouter =
                        new CalculusListViewItem(calculSav, resultatCALCUL_STRING);
                daoCalculHisto.insertCalculus(calculAAjouter);
                daoCalculHisto.close();
            }
        }
        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        else if(v.getId() == R.id.button35) {
            //BOUTON DYNAMIQUE +
            verifierEffacerZoneAffichageNan(zoneAffichage);
            if(this.sousClavierNumero >= 3 && this.sousClavierNumero <= 10)
                ajouterChaineZoneAffichage(zoneAffichage, this.listeStringBouton35.get(this.sousClavierNumero - 1) + "(");
            else
                ajouterChaineZoneAffichage(zoneAffichage, this.listeStringBouton35.get(this.sousClavierNumero - 1));
        }
        else if(v.getId() == R.id.button32) {
            //BOUTON DYNAMIQUE -
            verifierEffacerZoneAffichageNan(zoneAffichage);
            if(this.sousClavierNumero >= 3 && this.sousClavierNumero <= 10)
                ajouterChaineZoneAffichage(zoneAffichage, this.listeStringBouton32.get(this.sousClavierNumero - 1) + "(");
            else
                ajouterChaineZoneAffichage(zoneAffichage, this.listeStringBouton32.get(this.sousClavierNumero - 1));
        }
        else if(v.getId() == R.id.button28) {
            //BOUTON DYNAMIQUE MULTIPLIER
            verifierEffacerZoneAffichageNan(zoneAffichage);
            if(this.sousClavierNumero >= 3 && this.sousClavierNumero <= 11)
                ajouterChaineZoneAffichage(zoneAffichage, this.listeStringBouton28.get(this.sousClavierNumero - 1) + "(");
            else
                ajouterChaineZoneAffichage(zoneAffichage, this.listeStringBouton28.get(this.sousClavierNumero - 1));
        }
        else if(v.getId() == R.id.button24) {
            //BOUTON DYNAMIQUE DIVISER
            verifierEffacerZoneAffichageNan(zoneAffichage);
            if(this.sousClavierNumero >= 3 && this.sousClavierNumero <= 11)
                ajouterChaineZoneAffichage(zoneAffichage, this.listeStringBouton24.get(this.sousClavierNumero - 1) + "(");
            else
                ajouterChaineZoneAffichage(zoneAffichage, this.listeStringBouton24.get(this.sousClavierNumero - 1));
        }
        else if(v.getId() == R.id.button9) {
            //BOUTON DYNAMIQUE PUISSANCE
            verifierEffacerZoneAffichageNan(zoneAffichage);
            if(this.sousClavierNumero >= 3 && this.sousClavierNumero <= 11)
                ajouterChaineZoneAffichage(zoneAffichage, this.listeStringBouton9.get(this.sousClavierNumero - 1) + "(");
            else
                ajouterChaineZoneAffichage(zoneAffichage, this.listeStringBouton9.get(this.sousClavierNumero - 1));
        }
        else if(v.getId() == R.id.button14) {
            //Log.v("INFO", "C");
            effacerZoneAffichage(zoneAffichage);
        }
        else if(v.getId() == R.id.button15) {
            //Log.v("INFO", "A");
            MainActivity.CALCUL_STRING = "" + MainActivity.ANCIEN_RESULTAT;
            MainActivity.CALCUL_STRING = ColorText.colorierCalcule(this, MainActivity.CALCUL_STRING);
            zoneAffichage.setText(Html.fromHtml(MainActivity.CALCUL_STRING));
        }
        else if(v.getId() == R.id.button61) {
            //SOUS CLAVIER MOINS
            if(this.sousClavierNumero == 1)
                this.sousClavierNumero = MainActivity.SOUS_CLAVIER_NUMERO_MAX;
            else
                this.sousClavierNumero--;
            Button bdim = (Button)findViewById(R.id.button61);
            Button baug = (Button)findViewById(R.id.button68);
            bdim.setText("< " + this.sousClavierNumero);
            baug.setText("" + this.sousClavierNumero + " >");
            //Mise à jour affichage boutons dynamiques
            Button boutonPlus = findViewById(R.id.button35);
            boutonPlus.setText(this.listeStringBouton35.get(this.sousClavierNumero - 1));
            if(this.sousClavierNumero == 1)
                boutonPlus.setTextColor(Color.parseColor("#00b0f0"));
            else if(this.sousClavierNumero == 11)
                boutonPlus.setTextColor(Color.parseColor("#808080"));
            else
                boutonPlus.setTextColor(Color.parseColor("#f4a442"));

            Button boutonMoins = findViewById(R.id.button32);
            boutonMoins.setText(this.listeStringBouton32.get(this.sousClavierNumero - 1));
            if(this.sousClavierNumero == 1)
                boutonMoins.setTextColor(Color.parseColor("#00b0f0"));
            else if(this.sousClavierNumero == 11)
                boutonMoins.setTextColor(Color.parseColor("#808080"));
            else
                boutonMoins.setTextColor(Color.parseColor("#f4a442"));

            Button boutonMultiplier = findViewById(R.id.button28);
            boutonMultiplier.setText(this.listeStringBouton28.get(this.sousClavierNumero - 1));
            if(this.sousClavierNumero == 1)
                boutonMultiplier.setTextColor(Color.parseColor("#00b0f0"));
            else
                boutonMultiplier.setTextColor(Color.parseColor("#f4a442"));

            Button boutonDiviser = findViewById(R.id.button24);
            boutonDiviser.setText(this.listeStringBouton24.get(this.sousClavierNumero - 1));
            if(this.sousClavierNumero == 1)
                boutonDiviser.setTextColor(Color.parseColor("#00b0f0"));
            else if(this.sousClavierNumero == 2)
                boutonDiviser.setTextColor(Color.parseColor("#303f9f"));
            else
                boutonDiviser.setTextColor(Color.parseColor("#f4a442"));

            Button boutonPuissance = findViewById(R.id.button9);
            boutonPuissance.setText(this.listeStringBouton9.get(this.sousClavierNumero - 1));
            if(this.sousClavierNumero == 2)
                boutonPuissance.setTextColor(Color.parseColor("#303f9f"));
            else
                boutonPuissance.setTextColor(Color.parseColor("#f4a442"));
        }
        else if(v.getId() == R.id.button68) {
            //SOUS CLAVIER PLUS
            if(this.sousClavierNumero == MainActivity.SOUS_CLAVIER_NUMERO_MAX)
                this.sousClavierNumero = 1;
            else
                this.sousClavierNumero++;
            Button bdim = (Button)findViewById(R.id.button61);
            Button baug = (Button)findViewById(R.id.button68);
            bdim.setText("< " + this.sousClavierNumero);
            baug.setText("" + this.sousClavierNumero + " >");
            //Mise à jour affichage boutons dynamiques
            Button boutonPlus = findViewById(R.id.button35);
            boutonPlus.setText(this.listeStringBouton35.get(this.sousClavierNumero - 1));
            if(this.sousClavierNumero == 1)
                boutonPlus.setTextColor(Color.parseColor("#00b0f0"));
            else if(this.sousClavierNumero == 11)
                boutonPlus.setTextColor(Color.parseColor("#808080"));
            else
                boutonPlus.setTextColor(Color.parseColor("#f4a442"));

            Button boutonMoins = findViewById(R.id.button32);
            boutonMoins.setText(this.listeStringBouton32.get(this.sousClavierNumero - 1));
            if(this.sousClavierNumero == 1)
                boutonMoins.setTextColor(Color.parseColor("#00b0f0"));
            else if(this.sousClavierNumero == 11)
                boutonMoins.setTextColor(Color.parseColor("#808080"));
            else
                boutonMoins.setTextColor(Color.parseColor("#f4a442"));

            Button boutonMultiplier = findViewById(R.id.button28);
            boutonMultiplier.setText(this.listeStringBouton28.get(this.sousClavierNumero - 1));
            if(this.sousClavierNumero == 1)
                boutonMultiplier.setTextColor(Color.parseColor("#00b0f0"));
            else
                boutonMultiplier.setTextColor(Color.parseColor("#f4a442"));

            Button boutonDiviser = findViewById(R.id.button24);
            boutonDiviser.setText(this.listeStringBouton24.get(this.sousClavierNumero - 1));
            if(this.sousClavierNumero == 1)
                boutonDiviser.setTextColor(Color.parseColor("#00b0f0"));
            else if(this.sousClavierNumero == 2)
                boutonDiviser.setTextColor(Color.parseColor("#303f9f"));
            else
                boutonDiviser.setTextColor(Color.parseColor("#f4a442"));

            Button boutonPuissance = findViewById(R.id.button9);
            boutonPuissance.setText(this.listeStringBouton9.get(this.sousClavierNumero - 1));
            if(this.sousClavierNumero == 2)
                boutonPuissance.setTextColor(Color.parseColor("#303f9f"));
            else
                boutonPuissance.setTextColor(Color.parseColor("#f4a442"));
        }
        else if(v.getId() == R.id.button37) {
            //Log.v("INFO", "<");
            verifierEffacerZoneAffichageNan(zoneAffichage);
            MainActivity.CALCUL_STRING = zoneAffichage.getText().toString();
            int tailleCalcul = MainActivity.CALCUL_STRING.length();
            if(tailleCalcul > 0) {
                MainActivity.CALCUL_STRING = MainActivity.CALCUL_STRING.substring(0, tailleCalcul - 1);
            }
            MainActivity.CALCUL_STRING = ColorText.colorierCalcule(this, MainActivity.CALCUL_STRING);
            zoneAffichage.setText(Html.fromHtml(MainActivity.CALCUL_STRING));
        }
        else if(v.getId() == R.id.button39) { //BOUTON FONCTIONS
            Intent intentCatalogue = new Intent(this, Catalogue.class);
            startActivity(intentCatalogue);
        }
        else if(v.getId() == R.id.button47) { //BOUTON HISTO
            Intent intentHistorique = new Intent(this, Historique.class);
            startActivity(intentHistorique);
        }
        else if(v.getId() == R.id.button54) { //BOUTON INFO
            Intent intentInfoAppli = new Intent(this, InformationApplication.class);
            startActivity(intentInfoAppli);
        }
    }
}
