package com.aymerikaboso.calculator.model.calculus_list_view;

import android.content.Context;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.aymerikaboso.calculator.R;
import com.aymerikaboso.calculator.model.colortext.ColorText;

import java.util.ArrayList;

/**
 * Created by CFAPAG on 04/12/2017.
 */

public class CalculusAdapter extends ArrayAdapter<CalculusListViewItem> {
    private ArrayList<CalculusListViewItem> dataSet;
    Context mContext;

    // View lookup cache : VIEW HOLDER
    private static class ViewHolder {
        TextView calculusTextView;
        TextView egalTextView;
        TextView resultatTextView;
    }

    public CalculusAdapter(ArrayList<CalculusListViewItem> data, Context context) {
        super(context, R.layout.histo_list_cell, data);
        this.dataSet = data;
        this.mContext=context;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        CalculusListViewItem dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.histo_list_cell, parent, false);
            viewHolder.calculusTextView = (TextView) convertView.findViewById(R.id.textViewElement);
            viewHolder.egalTextView = (TextView) convertView.findViewById(R.id.textViewEgal);
            viewHolder.resultatTextView = (TextView) convertView.findViewById(R.id.textViewResultat);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.calculusTextView.setText(Html.fromHtml(ColorText.colorierCalcule(mContext, dataModel.getCalcul())));
        //viewHolder.calculusTextView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        viewHolder.egalTextView.setText(Html.fromHtml(ColorText.colorierCalcule(mContext, " = ")));
        //viewHolder.egalTextView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        viewHolder.resultatTextView.setText(Html.fromHtml(ColorText.colorierCalcule(mContext, dataModel.getResultat())));
        //viewHolder.resultatTextView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        // Return the completed view to render on screen
        return convertView;
    }
}
