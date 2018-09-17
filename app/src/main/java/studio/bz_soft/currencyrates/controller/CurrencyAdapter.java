package studio.bz_soft.currencyrates.controller;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import studio.bz_soft.currencyrates.R;
import studio.bz_soft.currencyrates.model.Currency;
import studio.bz_soft.currencyrates.model.CurrencyViewModel;

public class CurrencyAdapter extends ArrayAdapter {

    private static final String TAG = CurrencyAdapter.class.getSimpleName();

    private List<CurrencyViewModel> data;
    private int resource;
    private Boolean chbSelected;
    private LayoutInflater inflater;



    public CurrencyAdapter(Activity activity, @NonNull Context context, int resource,
                           int tvResource, int tvResource1) {
        super(context, resource);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        data = new ArrayList<>();
        this.resource = resource;
    }

    static class ViewHolder {
        ImageView imageViewCountry;
        TextView textViewAbbreviation;
        TextView textViewCurrencyName;
        ImageView imageViewChecked;
    }

    public void add(CurrencyViewModel item) {
        data.add(item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        View rowView = convertView;
        if (rowView == null) {
            rowView = inflater.inflate(resource, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.imageViewCountry = rowView.findViewById(R.id.imageViewCountry);
            viewHolder.textViewAbbreviation = rowView.findViewById(R.id.textViewAbbreviation);
            viewHolder.textViewCurrencyName = rowView.findViewById(R.id.textViewCurrencyName);
            viewHolder.imageViewChecked = rowView.findViewById(R.id.imageViewChecked);

            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        CurrencyViewModel item = data.get(position);
        Currency currency = item.getCurrency();

        viewHolder.textViewAbbreviation.setText(currency.getCurAbbreviation());
        viewHolder.textViewCurrencyName.setText(currency.getCurName());
        viewHolder.imageViewCountry.setImageDrawable(roundedImage(item.getCountryImage()));

        return rowView;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    private RoundedBitmapDrawable roundedImage(Bitmap bitmap) {
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.
                create(Resources.getSystem(), bitmap);
        roundedBitmapDrawable.setCornerRadius(Math.max(bitmap.getWidth(), bitmap.getHeight()));
        return roundedBitmapDrawable;
    }
}
