package com.aymerikaboso.calculator.model.colortext;

import android.content.Context;

import com.aymerikaboso.calculator.R;

/**
 * Created by CFAPAG on 29/11/2017.
 */

public class ColorText {
    public static String colorierCalcule(Context context, String calculString) {
        String couleurPoint = "#3f51b5";
        String couleurPlus = "#00b0f0";
        String couleurMoins = "#00b0f0";
        String couleurMultiplier = "#00b0f0";
        String couleurDiviser = "#00b0f0";
        String couleurParentheseOuvrante = "#303f9f";
        String couleurParentheseFermante = "#303f9f";
        String couleurEgal = "#f47a41";
        String couleurNaN = "#ff0000";
        String couleurPuissance = "#f4a442";

        String couleur_factorielle = "#f4a442"; //GENERE
        String couleur_virgule = "#f4a442";
        String couleur_abs = "#f4a442";
        String couleur_arccos = "#f4a442";
        String couleur_arccosech = "#f4a442";
        String couleur_arccosh = "#f4a442";
        String couleur_arcctan = "#f4a442";
        String couleur_arcctanh = "#f4a442";
        String couleur_arcsech = "#f4a442";
        String couleur_arcsin = "#f4a442";
        String couleur_arcsinh = "#f4a442";
        String couleur_arctan = "#f4a442";
        String couleur_arctanh = "#f4a442";
        String couleur_C = "#f4a442";
        String couleur_ceil = "#f4a442";
        String couleur_cos = "#f4a442";
        String couleur_cosec = "#f4a442";
        String couleur_cosech = "#f4a442";
        String couleur_cosh = "#f4a442";
        String couleur_ctan = "#f4a442";
        String couleur_ctanh = "#f4a442";
        String couleur_deg = "#f4a442";
        String couleur_exp = "#f4a442";
        String couleur_Fib = "#f4a442";
        String couleur_floor = "#f4a442";
        String couleur_gcd = "#f4a442";
        String couleur_int = "#f4a442";
        String couleur_ispr = "#f4a442";
        String couleur_lcm = "#f4a442";
        String couleur_ln = "#f4a442";
        String couleur_log = "#f4a442";
        String couleur_log10 = "#f4a442";
        String couleur_log2 = "#f4a442";
        String couleur_max = "#f4a442";
        String couleur_mean = "#f4a442";
        String couleur_min = "#f4a442";
        String couleur_mod = "#f4a442";
        String couleur_pi = "#f4a442";
        String couleur_rad = "#f4a442";
        String couleur_sec = "#f4a442";
        String couleur_sech = "#f4a442";
        String couleur_sin = "#f4a442";
        String couleur_sinh = "#f4a442";
        String couleur_solve = "#f4a442";
        String couleur_sqrt = "#f4a442";
        String couleur_tan = "#f4a442";
        String couleur_tanh = "#f4a442";
        //---
        String replacePoint = "<font color=" + couleurPoint + ">" + context.getResources().getString(R.string.bouton_point) + "</font>";
        String replacePlus = "<font color=" + couleurPlus + ">" + context.getResources().getString(R.string.bouton_plus) + "</font>";
        String replaceMoins = "<font color=" + couleurMoins + ">" + context.getResources().getString(R.string.bouton_moins) + "</font>";
        String replaceMultiplier = "<font color=" + couleurMultiplier + ">" + context.getResources().getString(R.string.bouton_multiplier) + "</font>";
        String replaceDiviser = "<font color=" + couleurDiviser + ">" + context.getResources().getString(R.string.bouton_diviser) + "</font>";
        String replaceParentheseOuvrante = "<font color=" + couleurParentheseOuvrante + ">" + context.getResources().getString(R.string.bouton_parenthese_ouvrante) + "</font>";
        String replaceParentheseFermante = "<font color=" + couleurParentheseFermante + ">" + context.getResources().getString(R.string.bouton_parenthese_fermante) + "</font>";
        String replaceEgal = "<font color=" + couleurEgal + ">" + " " + context.getResources().getString(R.string.bouton_egal) + " " + "</font>";
        String replaceNaN = "<font color=" + couleurNaN + ">" + context.getResources().getString(R.string.NaN) + "</font>";
        String replacePuissance = "<font color=" + couleurPuissance + ">" + context.getResources().getString(R.string.bouton_puissance) + "</font>";

        String replace_factorielle = "<font color=" + couleur_factorielle + ">" + context.getResources().getString(R.string.bouton_factorielle) + "</font>"; //GENERE
        String replace_virgule = "<font color=" + couleur_virgule + ">" + context.getResources().getString(R.string.bouton_virgule) + "</font>";
        String replace_abs = "<font color=" + couleur_abs + ">" + context.getResources().getString(R.string.bouton_abs) + "</font>";
        String replace_arccos = "<font color=" + couleur_arccos + ">" + context.getResources().getString(R.string.bouton_arccos) + "</font>";
        String replace_arccosech = "<font color=" + couleur_arccosech + ">" + context.getResources().getString(R.string.bouton_arccosech) + "</font>";
        String replace_arccosh = "<font color=" + couleur_arccosh + ">" + context.getResources().getString(R.string.bouton_arccosh) + "</font>";
        String replace_arcctan = "<font color=" + couleur_arcctan + ">" + context.getResources().getString(R.string.bouton_arcctan) + "</font>";
        String replace_arcctanh = "<font color=" + couleur_arcctanh + ">" + context.getResources().getString(R.string.bouton_arcctanh) + "</font>";
        String replace_arcsech = "<font color=" + couleur_arcsech + ">" + context.getResources().getString(R.string.bouton_arcsech) + "</font>";
        String replace_arcsin = "<font color=" + couleur_arcsin + ">" + context.getResources().getString(R.string.bouton_arcsin) + "</font>";
        String replace_arcsinh = "<font color=" + couleur_arcsinh + ">" + context.getResources().getString(R.string.bouton_arcsinh) + "</font>";
        String replace_arctan = "<font color=" + couleur_arctan + ">" + context.getResources().getString(R.string.bouton_arctan) + "</font>";
        String replace_arctanh = "<font color=" + couleur_arctanh + ">" + context.getResources().getString(R.string.bouton_arctanh) + "</font>";
        String replace_C = "<font color=" + couleur_C + ">" + context.getResources().getString(R.string.bouton_C) + "</font>";
        String replace_ceil = "<font color=" + couleur_ceil + ">" + context.getResources().getString(R.string.bouton_ceil) + "</font>";
        String replace_cos = "<font color=" + couleur_cos + ">" + context.getResources().getString(R.string.bouton_cos) + "</font>";
        String replace_cosec = "<font color=" + couleur_cosec + ">" + context.getResources().getString(R.string.bouton_cosec) + "</font>";
        String replace_cosech = "<font color=" + couleur_cosech + ">" + context.getResources().getString(R.string.bouton_cosech) + "</font>";
        String replace_cosh = "<font color=" + couleur_cosh + ">" + context.getResources().getString(R.string.bouton_cosh) + "</font>";
        String replace_ctan = "<font color=" + couleur_ctan + ">" + context.getResources().getString(R.string.bouton_ctan) + "</font>";
        String replace_ctanh = "<font color=" + couleur_ctanh + ">" + context.getResources().getString(R.string.bouton_ctanh) + "</font>";
        String replace_deg = "<font color=" + couleur_deg + ">" + context.getResources().getString(R.string.bouton_deg) + "</font>";
        String replace_exp = "<font color=" + couleur_exp + ">" + context.getResources().getString(R.string.bouton_exp) + "</font>";
        String replace_Fib = "<font color=" + couleur_Fib + ">" + context.getResources().getString(R.string.bouton_Fib) + "</font>";
        String replace_floor = "<font color=" + couleur_floor + ">" + context.getResources().getString(R.string.bouton_floor) + "</font>";
        String replace_gcd = "<font color=" + couleur_gcd + ">" + context.getResources().getString(R.string.bouton_gcd) + "</font>";
        String replace_int = "<font color=" + couleur_int + ">" + context.getResources().getString(R.string.bouton_int) + "</font>";
        String replace_ispr = "<font color=" + couleur_ispr + ">" + context.getResources().getString(R.string.bouton_ispr) + "</font>";
        String replace_lcm = "<font color=" + couleur_lcm + ">" + context.getResources().getString(R.string.bouton_lcm) + "</font>";
        String replace_ln = "<font color=" + couleur_ln + ">" + context.getResources().getString(R.string.bouton_ln) + "</font>";
        String replace_log = "<font color=" + couleur_log + ">" + context.getResources().getString(R.string.bouton_log) + "</font>";
        String replace_log10 = "<font color=" + couleur_log10 + ">" + context.getResources().getString(R.string.bouton_log10) + "</font>";
        String replace_log2 = "<font color=" + couleur_log2 + ">" + context.getResources().getString(R.string.bouton_log2) + "</font>";
        String replace_max = "<font color=" + couleur_max + ">" + context.getResources().getString(R.string.bouton_max) + "</font>";
        String replace_mean = "<font color=" + couleur_mean + ">" + context.getResources().getString(R.string.bouton_mean) + "</font>";
        String replace_min = "<font color=" + couleur_min + ">" + context.getResources().getString(R.string.bouton_min) + "</font>";
        String replace_mod = "<font color=" + couleur_mod + ">" + context.getResources().getString(R.string.bouton_mod) + "</font>";
        String replace_pi = "<font color=" + couleur_pi + ">" + context.getResources().getString(R.string.bouton_pi) + "</font>";
        String replace_rad = "<font color=" + couleur_rad + ">" + context.getResources().getString(R.string.bouton_rad) + "</font>";
        String replace_sec = "<font color=" + couleur_sec + ">" + context.getResources().getString(R.string.bouton_sec) + "</font>";
        String replace_sech = "<font color=" + couleur_sech + ">" + context.getResources().getString(R.string.bouton_sech) + "</font>";
        String replace_sin = "<font color=" + couleur_sin + ">" + context.getResources().getString(R.string.bouton_sin) + "</font>";
        String replace_sinh = "<font color=" + couleur_sinh + ">" + context.getResources().getString(R.string.bouton_sinh) + "</font>";
        String replace_solve = "<font color=" + couleur_solve + ">" + context.getResources().getString(R.string.bouton_solve) + "</font>";
        String replace_sqrt = "<font color=" + couleur_sqrt + ">" + context.getResources().getString(R.string.bouton_sqrt) + "</font>";
        String replace_tan = "<font color=" + couleur_tan + ">" + context.getResources().getString(R.string.bouton_tan) + "</font>";
        String replace_tanh = "<font color=" + couleur_tanh + ">" + context.getResources().getString(R.string.bouton_tanh) + "</font>";
        //---
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_point), replacePoint);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_plus), replacePlus);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_moins), replaceMoins);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_multiplier), replaceMultiplier);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_diviser), replaceDiviser);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_parenthese_ouvrante), replaceParentheseOuvrante);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_parenthese_fermante), replaceParentheseFermante);
        calculString = calculString.replace(" " + context.getResources().getString(R.string.bouton_egal) + " ", replaceEgal);
        calculString = calculString.replace(context.getResources().getString(R.string.NaN), replaceNaN);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_puissance), replacePuissance);

        calculString = calculString.replace(context.getResources().getString(R.string.bouton_factorielle), replace_factorielle); //GENERE
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_virgule), replace_virgule);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_abs), replace_abs);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_arccosh), replace_arccosh);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_arccosech), replace_arccosech);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_arccos), replace_arccos);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_arcctanh), replace_arcctanh);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_arcctan), replace_arcctan);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_arcsech), replace_arcsech);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_arcsinh), replace_arcsinh);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_arcsin), replace_arcsin);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_arctanh), replace_arctanh);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_arctan), replace_arctan);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_C), replace_C);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_ceil), replace_ceil);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_cosech), replace_cosech);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_cosec), replace_cosec);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_cosh), replace_cosh);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_cos), replace_cos);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_ctanh), replace_ctanh);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_ctan), replace_ctan);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_deg), replace_deg);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_exp), replace_exp);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_Fib), replace_Fib);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_floor), replace_floor);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_gcd), replace_gcd);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_int), replace_int);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_ispr), replace_ispr);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_lcm), replace_lcm);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_ln), replace_ln);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_log10), replace_log10);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_log2), replace_log2);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_log), replace_log);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_max), replace_max);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_mean), replace_mean);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_min), replace_min);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_mod), replace_mod);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_pi), replace_pi);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_rad), replace_rad);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_sech), replace_sech);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_sec), replace_sec);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_sinh), replace_sinh);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_sin), replace_sin);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_solve), replace_solve);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_sqrt), replace_sqrt);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_tanh), replace_tanh);
        calculString = calculString.replace(context.getResources().getString(R.string.bouton_tan), replace_tan);

        return calculString;
    }
}
