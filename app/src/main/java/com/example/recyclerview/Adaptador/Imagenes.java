package com.example.recyclerview.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.R;

import java.util.List;

public class Imagenes extends RecyclerView.Adapter<Imagenes.ImagenesViewHolder> {
    private Context Ctx;
    private List<String> lstImagenes;
    public Imagenes(Context mCtx, List<String> imagenes) {
        this.lstImagenes = imagenes;
        Ctx = mCtx;
    }

    @NonNull
    @Override
    public Imagenes.ImagenesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.lyimagenes, null);
        return new Imagenes.ImagenesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Imagenes.ImagenesViewHolder holder, int position) {
        String imagen = lstImagenes.get(position);

        Glide.with(Ctx)
                .load(imagen)
                .into(holder.Productoimg);
    }


    @Override
    public int getItemCount() {
        return lstImagenes.size();    }
    class ImagenesViewHolder extends RecyclerView.ViewHolder {

        ImageView Productoimg;
        CardView Producto;

        public ImagenesViewHolder(View itemView) {
            super(itemView);
            Productoimg = itemView.findViewById(R.id.Productoimg);
            Producto = itemView.findViewById(R.id.Producto);
        }
    }
}
