package com.example.pizzahutapp_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ArrayList<DataModel> myProducts;

    RecyclerView myRecyclerView;

    ProductCustomAdapter myProductCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView8);
        Glide.with(this).asGif().load(R.drawable.carga1).into(imageView);

        myProducts = new ArrayList<>();
        SingletonCard.myCart = new ArrayList<>();
        SingletonCard.totalPrice=0;

        myProducts.add(new DataModel("2x1 Grandes de Jamon",21950,R.drawable.img_1));
        myProducts.add(new DataModel("Big 4",3500,R.drawable.img_5));

        myRecyclerView = findViewById(R.id.recyclerViewProducts);
        myProductCustomAdapter = new ProductCustomAdapter(myProducts);

        myRecyclerView.setAdapter(myProductCustomAdapter);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView imageViewGoCart = findViewById(R.id.imageViewGoCart);

        imageViewGoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        ImageView myImageView3 = (ImageView) findViewById(R.id.imageView5);
        myImageView3.setImageResource(R.drawable.img_2);

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
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                        break;
                    }
                }
                return true;
            }
        });

    }
    public void addToCart(View v){
        DataModel object = (DataModel) v.getTag();
        SingletonCard.myCart.add(object);
        SingletonCard.totalPrice += object.getProduct_price();
        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(intent);
//        Log.d("mainactivity",""+SingletonCard.totalPrice);
    }
}