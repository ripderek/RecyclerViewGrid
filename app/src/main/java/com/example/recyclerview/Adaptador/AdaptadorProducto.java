package com.example.recyclerview.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.ImagenesProducto;
import com.example.recyclerview.Modelos.Producto;
import com.example.recyclerview.R;

import java.util.List;

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.ProductoViewHolder>{
    private Context Ctx;
    private List<Producto>  lstProducto;

    public AdaptadorProducto(Context mCtx, List<Producto> productos){
        this.lstProducto= productos;
        this.Ctx = mCtx;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.lyitemproducto, null);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorProducto.ProductoViewHolder holder, int position) {
        Producto usuario = lstProducto.get(position);
        holder.txtTitle.setText(usuario.getTitle());
        holder.txtPrecio.setText(usuario.getPrice());
        holder.txtDescripcion.setText(usuario.getRating());


        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();

                b.putStringArray("Imagenes", usuario.getImagenes());
                b.putString("Titulo", usuario.getTitle());
                b.putString("Descripcion", usuario.getDescription());

                Intent intent = new Intent(Ctx, ImagenesProducto.class);
                intent.putExtras(b);
                Ctx.startActivity(intent);
            }
        });



        Glide.with(Ctx)
                .load(usuario.getThumbail())
                .into(holder.Productoimg);
    }

    @Override
    public int getItemCount() {
        return lstProducto.size();
    }

    class ProductoViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle,txtPrecio,txtDescripcion;
        ImageView Productoimg;
        CardView cardview;
        public ProductoViewHolder(View itemView){
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
            Productoimg = itemView.findViewById(R.id.Productoimg);
            cardview = itemView.findViewById(R.id.Producto);
        }
    }
}
