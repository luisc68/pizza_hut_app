package com.example.pizzahutapp_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductCustomAdapter extends RecyclerView.Adapter<ProductCustomAdapter.ViewHolder> {

    private ArrayList<DataModel> myData;

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView productImageView;
        private Button addButton;

        ViewHolder(View itemView){
            super(itemView);

            productImageView = itemView.findViewById(R.id.imageViewProducts);
            addButton = itemView.findViewById(R.id.buttonProductAdd);
        }
    }
    public ProductCustomAdapter(ArrayList<DataModel> myData){
            this.myData = myData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.product_row_template, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DataModel object = myData.get(position);

        ImageView imageView = holder.productImageView;
        Button addButton = holder.addButton;

        imageView.setImageResource(object.getProduct_img());
        addButton.setTag(object);
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }
}
