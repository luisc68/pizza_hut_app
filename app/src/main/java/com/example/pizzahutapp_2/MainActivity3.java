package com.example.pizzahutapp_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    RecyclerView myCartRecycler;
    TextView totalToPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main3);

        myCartRecycler = findViewById(R.id.cartRecyclerView);
        totalToPay = findViewById(R.id.textViewTotal);
        //decimal format
        DecimalFormat formatter = new DecimalFormat("#,###");
        totalToPay.setText("₡ "+ formatter.format(SingletonCard.totalPrice));

        CartCustomAdapter cartAdapter = new CartCustomAdapter(SingletonCard.myCart, totalToPay);
        myCartRecycler.setAdapter(cartAdapter);
        myCartRecycler.setLayoutManager(new LinearLayoutManager(this));

        ImageView regresarBtn = findViewById(R.id.imageView26);
        regresarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView cancelarBtn = findViewById(R.id.imageView25);
        cancelarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity3.this)
                        .setTitle("Cancel Order")
                        .setMessage("Are you sure you want to cancel the order?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),"Order has been cancelled",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });


        ImageView finalizadoBtn = (ImageView) findViewById(R.id.imageView23);
        finalizadoBtn.setImageResource(R.drawable.img_74);

        finalizadoBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        // Agregar el efecto visual de presionar el botón aquí
                        finalizadoBtn.setAlpha(0.5f); // Cambiar la opacidad del ImageView a la mitad
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        // Agregar el efecto visual de soltar el botón aquí
                        finalizadoBtn.setAlpha(1.0f); // Restaurar la opacidad del ImageView


                        // Agregar el Intent para ir a la siguiente actividad aquí
                        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                        Toast.makeText(getApplicationContext(),"Order Successfully Completed",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        break;
                    }
                }
                return true;
            }
        });
    }
}
