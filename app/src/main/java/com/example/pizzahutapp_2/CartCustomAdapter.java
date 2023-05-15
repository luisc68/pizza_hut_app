package com.example.pizzahutapp_2;

import android.content.Context;
import android.util.Log;
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
import java.util.Locale;

public class CartCustomAdapter extends RecyclerView.Adapter<CartCustomAdapter.ViewHolder> {
    private ArrayList<DataModel> myCartData;
    private TextView totalToPay;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView prPic;
        public TextView prName;
        public TextView prPrice;
        public Button removeButton;

        public ViewHolder(View itemView) {
            super(itemView);
            prPic = itemView.findViewById(R.id.imageView4);
            prName = itemView.findViewById(R.id.textViewProduct);
            prPrice = itemView.findViewById(R.id.textViewPrice);
            removeButton = itemView.findViewById(R.id.buttonRemove);
        }
    }

    public CartCustomAdapter(ArrayList<DataModel> myData, TextView totalToPayTextView) {
        this.myCartData = myData;
        this.totalToPay = totalToPayTextView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View cardView = inflater.inflate(R.layout.cart_row_template, parent, false);
        ViewHolder viewHolder = new ViewHolder(cardView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Decimal format
        DecimalFormat formatter = new DecimalFormat("#,###");

        DataModel myModel = myCartData.get(position);
        ImageView prPic = holder.prPic;
        TextView prName = holder.prName;
        TextView prPrice = holder.prPrice;
        Button removeButton = holder.removeButton;

        prName.setText(myModel.getProduct_name());
        //price with decimal format
        prPrice.setText("₡ " + formatter.format(myModel.getProduct_price()));
        prPic.setImageResource(myModel.getProduct_img());

        // Agregar un OnClickListener al botón de "remove"
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el índice del elemento que se está eliminando
                int index = holder.getAdapterPosition();
                // Obtener el precio del producto a remover
                double priceToRemove = myCartData.get(index).getProduct_price();
                // Eliminar el elemento de la lista
                myCartData.remove(index);
                // Notificar al adaptador que se eliminó un elemento en el índice correspondiente
                notifyItemRemoved(index);
                // Actualizar el precio total del carrito
                SingletonCard.totalPrice -= priceToRemove;
                // Actualizar el TextView del precio total con decimal format
                totalToPay.setText("₡ " + formatter.format(SingletonCard.totalPrice));

                //totalToPay.setText(String.format(Locale.getDefault(), "%.2f", SingletonCard.totalPrice));
            }
        });
    }

    public int getItemCount() {
        return myCartData.size();
    }
}
