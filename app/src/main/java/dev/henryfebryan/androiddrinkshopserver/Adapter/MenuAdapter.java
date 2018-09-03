package dev.henryfebryan.androiddrinkshopserver.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import dev.henryfebryan.androiddrinkshopserver.Adapter.ViewHolder.MenuViewHolder;
import dev.henryfebryan.androiddrinkshopserver.DrinkListActivity;
import dev.henryfebryan.androiddrinkshopserver.Interface.IItemClickListener;
import dev.henryfebryan.androiddrinkshopserver.Model.Category;
import dev.henryfebryan.androiddrinkshopserver.R;
import dev.henryfebryan.androiddrinkshopserver.UpdateCategoryActivity;
import dev.henryfebryan.androiddrinkshopserver.Utils.Common;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder>{

    Context context;
    List<Category> categoryList;

    public MenuAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.menu_item_layout,parent,false);
        return new MenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, final int position) {
        Picasso.with(context)
                .load(categoryList.get(position).Link)
                .into(holder.img_product);
        holder.txt_product.setText(categoryList.get(position).Name);

        holder.setItemClickListener(new IItemClickListener() {
            @Override
            public void onClick(View view, boolean isLongClick) {
                if(isLongClick) {
                    Common.currentCategory = categoryList.get(position);
                    context.startActivity(new Intent(context, UpdateCategoryActivity.class));
                }
                else {
                    Common.currentCategory = categoryList.get(position);
                    context.startActivity(new Intent(context, DrinkListActivity.class));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
