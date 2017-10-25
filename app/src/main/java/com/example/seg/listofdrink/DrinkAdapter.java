package com.example.seg.listofdrink;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by seg on 24.10.17.
 */

public class DrinkAdapter  extends RecyclerView.Adapter<DrinkAdapter.ViewHolder> implements Filterable {

    private ArrayList<Drink> mArrayList;
    private ArrayList<Drink> mFilteredList;

    public DrinkAdapter(ArrayList<Drink> arrayList) {
        mArrayList = arrayList;
        mFilteredList = arrayList;
    }


    @Override
    public DrinkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DrinkAdapter.ViewHolder holder, int position) {
        holder.tv_drink_name.setText(mFilteredList.get(position).getName());
        holder.tv_drink_volume.setText(String.valueOf(mFilteredList.get(position).getVolume()));
        holder.tv_drink_content.setText(String.valueOf(mFilteredList.get(position).getAlcoholContent()));
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {
                    mFilteredList = mArrayList;
                } else {
                    ArrayList<Drink> filteredList = new ArrayList<>();

                    for (Drink drink : mArrayList) {
                        if ( drink.getName().toLowerCase().contains(charString) ) {
                            filteredList.add(drink);
                        }
                    }
                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<Drink>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_drink_name,tv_drink_volume,tv_drink_content;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_drink_name = itemView.findViewById(R.id.tv_drink_name);
            tv_drink_volume = itemView.findViewById(R.id.tv_drink_volume);
            tv_drink_content = itemView.findViewById(R.id.tv_drink_content);
        }
    }
}
