package com.example.pizzahutapp_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ImageView imageView = findViewById(R.id.imageView20);
        Glide.with(this).asGif().load(R.drawable.tocadiscos).into(imageView);
        ImageView imageView22 = findViewById(R.id.imageView22);
        Glide.with(this).asGif().load(R.drawable.rocola).into(imageView22);

        ImageView finalizado = (ImageView) findViewById(R.id.imageView16);
        finalizado.setImageResource(R.drawable.img_52);

        finalizado.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        // Agregar el efecto visual de presionar el botón aquí
                        finalizado.setAlpha(0.5f); // Cambiar la opacidad del ImageView a la mitad
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        // Agregar el efecto visual de soltar el botón aquí
                        finalizado.setAlpha(1.0f); // Restaurar la opacidad del ImageView


                        // Agregar el Intent para ir a la siguiente actividad aquí
                        Intent intent = new Intent(MainActivity4.this, MainActivity.class);
                        Toast.makeText(getApplicationContext(),"Thank You",Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        break;
                    }
                }
                return true;
            }
        });
    }
}