package dev.henryfebryan.androiddrinkshopserver.Adapter.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import dev.henryfebryan.androiddrinkshopserver.Interface.IItemClickListener;
import dev.henryfebryan.androiddrinkshopserver.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ImageView img_product;
    public TextView txt_product;

    IItemClickListener itemClickListener;

    public void setItemClickListener(IItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public MenuViewHolder(View itemView) {
        super(itemView);

        img_product = (ImageView) itemView.findViewById(R.id.img_product);
        txt_product = (TextView) itemView.findViewById(R.id.txt_menu_name);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v);
    }
}
