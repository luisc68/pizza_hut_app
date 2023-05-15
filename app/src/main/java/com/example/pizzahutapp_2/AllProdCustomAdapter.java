package com.example.pizzahutapp_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AllProdCustomAdapter extends RecyclerView.Adapter<AllProdCustomAdapter.ViewHolder>{

    private ArrayList<DataModel> allProdData;

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView productImageView;

        private TextView nameTextView;
        private TextView priceTextView;

        private Button addButton;

        ViewHolder(View itemView){
            super(itemView);

            productImageView = itemView.findViewById(R.id.imageViewPromoImg);
            nameTextView = itemView.findViewById(R.id.idnombrepromo);
            priceTextView = itemView.findViewById(R.id.idpricepromo);

            addButton = itemView.findViewById(R.id.buttonAllProd);
        }
    }
    public AllProdCustomAdapter(ArrayList<DataModel> allProdData){
        this.allProdData = allProdData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.allprod_template, parent, false);

        AllProdCustomAdapter.ViewHolder viewHolder = new AllProdCustomAdapter.ViewHolder(contactView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        DataModel object = allProdData.get(position);

        ImageView imageView = holder.productImageView;
        TextView nameTextView = holder.nameTextView;
        //price con decimal format
        TextView priceTextView = holder.priceTextView;
        //TextView priceTextView = holder.priceTextView;

        Button addButton = holder.addButton;

        imageView.setImageResource(object.getProduct_img());
        nameTextView.setText(object.getProduct_name());
        //price con decimal format
        priceTextView.setText("₡ " + formatter.format(object.getProduct_price()));
        //priceTextView.setText(String.valueOf(object.getProduct_price()));
        addButton.setTag(object);
    }

    @Override
    public int getItemCount() {
        return allProdData.size();
    }
}
