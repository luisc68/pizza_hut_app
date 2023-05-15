package com.example.pizzahutapp_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ArrayList<DataModel> allPromos;

    RecyclerView myRecyclerView;

    AllProdCustomAdapter myAllProdCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);

        allPromos = new ArrayList<>();
        SingletonCard.myCart = new ArrayList<>();


        allPromos.add(new DataModel("2x1  Medianas",2500,R.drawable.img_54));
        allPromos.add(new DataModel(" Pizzas con borde relleno de queso ",10500,R.drawable.img_55));
        allPromos.add(new DataModel("Disfruta al triple",10500,R.drawable.img_56));
        allPromos.add(new DataModel("Fut Box",21950,R.drawable.img_57));
        allPromos.add(new DataModel("My Box",3500,R.drawable.img_58));
        allPromos.add(new DataModel("La Favorita",6500,R.drawable.img_59));
        allPromos.add(new DataModel("Mitad y Mitad",8500,R.drawable.img_60));
        allPromos.add(new DataModel("Mediana",6000,R.drawable.img_61));
        allPromos.add(new DataModel("2x1 Pepperoni Medianas",9500,R.drawable.img_62));
        allPromos.add(new DataModel("Paquete Hut Wings Amigos Mediana",18950,R.drawable.img_63));
        allPromos.add(new DataModel("Paquete Hut Wings Amigos Grande",21950,R.drawable.img_64));
        allPromos.add(new DataModel("Paquete Hut Wings Familiar Mediano",15950,R.drawable.img_65));
        allPromos.add(new DataModel("Paquete Hut Wings Familiar Grande",17950,R.drawable.img_66));
        allPromos.add(new DataModel("AK7",5950,R.drawable.img_67));
        allPromos.add(new DataModel("BIG HUT ALITAS",17950,R.drawable.img_68));
        allPromos.add(new DataModel("BIG HUT ENSALADA",19950,R.drawable.img_69));
        allPromos.add(new DataModel("BIG HUT POPPERS",15950,R.drawable.img_70));



        myRecyclerView = findViewById(R.id.recyclerViewAllProducts);
        myAllProdCustomAdapter = new AllProdCustomAdapter(allPromos);

        myRecyclerView.setAdapter(myAllProdCustomAdapter);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //ImageView imageView1 = findViewById(R.id.imageView17);
       // ImageView imageView2 = findViewById(R.id.imageView18);

        ImageView myImageView3 = (ImageView) findViewById(R.id.imageViewGoCart);
        myImageView3.setImageResource(R.drawable.gotocart);

        myImageView3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        // Agregar el efecto visual de presionar el botón aquí
                        myImageView3.setAlpha(0.5f); // Cambiar la opacidad del ImageView a la mitad
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        // Agregar el efecto visual de soltar el botón aquí
                        myImageView3.setAlpha(1.0f); // Restaurar la opacidad del ImageView


                        // Agregar el Intent para ir a la siguiente actividad aquí
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                        startActivity(intent);
                        break;
                    }
                }
                return true;
            }
        });
        ImageView imageViewGoCart = findViewById(R.id.imageViewGoCart);

        imageViewGoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

//        imageView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "No hay mas promociones disponibles", Toast.LENGTH_SHORT).show();
//            }
//        });
//        imageView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
//                startActivity(intent);            }
//        });
    }
    public void addToCart(View v){
        DataModel object = (DataModel) v.getTag();
        Toast.makeText(this,"Add to cart: " + object.getProduct_name(),Toast.LENGTH_SHORT).show();
        SingletonCard.myCart.add(object);
        SingletonCard.totalPrice += object.getProduct_price();

    }
}