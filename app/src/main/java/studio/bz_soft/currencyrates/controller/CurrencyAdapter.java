package studio.bz_soft.currencyrates.controller;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import studio.bz_soft.currencyrates.R;
import studio.bz_soft.currencyrates.model.Currency;

public class CurrencyAdapter extends ArrayAdapter {

    private List<Currency> currencyList;
//    private ListImages listImages;
    private int resource;
    private int tvResource;
    private int tvResource1;
    private Activity activity;
    private LayoutInflater inflater;


    public CurrencyAdapter(Activity activity, @NonNull Context context, int resource,
                           int tvResource, int tvResource1, @NonNull List objects) {
        super(context, resource, objects);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        currencyList = objects;
        this.resource = resource;
        this.tvResource = tvResource;
        this.tvResource1 = tvResource1;
        this.activity = activity;
    }

    static class ViewHolder {
        ImageView imageViewCountry;
        TextView textViewAbbreviation;
        TextView textViewCurrencyName;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        View rowView = convertView;
        if (rowView == null) {
            rowView = inflater.inflate(resource, parent, false);
            viewHolder = new ViewHolder();
//            viewHolder.imageViewCountry = rowView.findViewById(R.id.imageViewCountry);
            viewHolder.textViewAbbreviation = rowView.findViewById(R.id.textViewAbbreviation);
            viewHolder.textViewCurrencyName = rowView.findViewById(R.id.textViewCurrencyName);
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        Currency currency = getCurrency(position);

        viewHolder.textViewAbbreviation.setText(currency.getCurAbbreviation());
        viewHolder.textViewCurrencyName.setText(currency.getCurName());

        return rowView;
    }

    @Override
    public int getCount() {
        return currencyList.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return currencyList.get(position);
    }

    private Currency getCurrency(int position) {
        return (Currency) getItem(position);
    }
}
