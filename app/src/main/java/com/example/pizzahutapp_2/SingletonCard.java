package com.example.pizzahutapp_2;

import java.util.ArrayList;

public class SingletonCard {
    public static double totalPrice;
    public static ArrayList<DataModel> myCart = new ArrayList<>();

    // Función para calcular el precio total del carrito
    public static void updateTotalPrice() {
        totalPrice = 0.0;
        for (DataModel item : myCart) {
            totalPrice += item.getProduct_price();
        }
    }
}

