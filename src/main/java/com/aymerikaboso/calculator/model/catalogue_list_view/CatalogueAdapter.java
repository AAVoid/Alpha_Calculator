package com.aymerikaboso.calculator.model.catalogue_list_view;

import android.content.Context;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.aymerikaboso.calculator.R;
import com.aymerikaboso.calculator.model.calculus_list_view.CalculusAdapter;
import com.aymerikaboso.calculator.model.calculus_list_view.CalculusListViewItem;
import com.aymerikaboso.calculator.model.colortext.ColorText;

import java.util.ArrayList;

/**
 * Created by CFAPAG on 31/12/2017.
 */

public class CatalogueAdapter extends ArrayAdapter<CatalogueListViewItem> {
    private ArrayList<CatalogueListViewItem> dataSet;
    Context mContext;

    // View lookup cache : VIEW HOLDER
    private static class ViewHolder {
        TextView fonctionTextView;
        TextView descriptionTextView;
        TextView exempleTextView;
    }

    public CatalogueAdapter(ArrayList<CatalogueListViewItem> data, Context context) {
        super(context, R.layout.catalogue_list_cell, data);
        this.dataSet = data;
        this.mContext=context;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        CatalogueListViewItem dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.catalogue_list_cell, parent, false);
            viewHolder.fonctionTextView = (TextView) convertView.findViewById(R.id.textViewElement);
            viewHolder.descriptionTextView = (TextView) convertView.findViewById(R.id.textViewDescription);
            viewHolder.exempleTextView = (TextView) convertView.findViewById(R.id.textViewExemple);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.fonctionTextView.setText(Html.fromHtml(ColorText.colorierCalcule(mContext, dataModel.getFonction())));
        //viewHolder.fonctionTextView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        viewHolder.descriptionTextView.setText(dataModel.getDescription());
        //viewHolder.descriptionTextView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        viewHolder.exempleTextView.setText(Html.fromHtml(ColorText.colorierCalcule(mContext, dataModel.getExemple())));
        //viewHolder.exempleTextView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        // Return the completed view to render on screen
        return convertView;
    }
}
