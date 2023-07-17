package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.recyclerview.Adaptador.Imagenes;

import java.util.Arrays;
import java.util.List;

public class ImagenesProducto extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes_producto);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerimagenes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        Bundle b = this.getIntent().getExtras();
        String [] imag = b.getStringArray("Imagenes");
        List<String> lstImagenes = Arrays.asList(imag);


        TextView titulo = (TextView)findViewById(R.id.producto) ;
        titulo.setText(b.getString("Titulo"));
        Imagenes adapterIma = new Imagenes(this, lstImagenes);
        recyclerView.setAdapter(adapterIma);
    }
}