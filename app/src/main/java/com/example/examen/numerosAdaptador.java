package com.example.examen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class numerosAdaptador extends RecyclerView.Adapter<numerosAdaptador.viewHolder> {
    public final ArrayList<ganadores> L;

    public numerosAdaptador(ArrayList<ganadores> l) {
        L = l;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        String Nombre = L.get(position).getNombre();
        String Cantidad = L.get(position).getCantidad();
        holder.Nombre.setText(Nombre);
        holder.Cantidad.setText(Cantidad);
        Picasso.get().load("https://fer-uig.glitch.me").into(holder.imagen);
    }

    @Override
    public int getItemCount() {
        return L.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView Nombre;
        TextView Cantidad;
        ImageView imagen;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre = (TextView)itemView.findViewById(R.id.tx1);
            Cantidad = (TextView)itemView.findViewById(R.id.tx2);
            imagen = (ImageView)itemView.findViewById(R.id.imagen);
        }
    }
}
