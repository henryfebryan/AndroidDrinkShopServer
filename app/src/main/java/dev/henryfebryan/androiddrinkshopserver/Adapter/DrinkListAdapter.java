package dev.henryfebryan.androiddrinkshopserver.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import dev.henryfebryan.androiddrinkshopserver.Adapter.ViewHolder.DrinkListViewHolder;
import dev.henryfebryan.androiddrinkshopserver.Interface.IItemClickListener;
import dev.henryfebryan.androiddrinkshopserver.Model.Drink;
import dev.henryfebryan.androiddrinkshopserver.R;

public class DrinkListAdapter extends RecyclerView.Adapter<DrinkListViewHolder> {

    Context context;
    List<Drink> drinkList;

    public DrinkListAdapter(Context context, List<Drink> drinkList) {
        this.context = context;
        this.drinkList = drinkList;
    }

    @NonNull
    @Override
    public DrinkListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.drink_item_layout,parent,false);
        return new DrinkListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkListViewHolder holder, int position) {
        Picasso.with(context).load(drinkList.get(position).Link).into(holder.img_product);
        holder.txt_price.setText(new StringBuilder("$").append(drinkList.get(position).Price).toString());
        holder.txt_drink_name.setText(drinkList.get(position).Name);

        holder.setItemClickListener(new IItemClickListener() {
            @Override
            public void onClick(View view, boolean isLongClick) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }
}
