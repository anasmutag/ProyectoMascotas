package com.example.proyectomascotas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectomascotas.R;
import com.example.proyectomascotas.pojo.Mascota;

import java.util.ArrayList;

public class FotosAdapter extends RecyclerView.Adapter<FotosAdapter.FotosViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public FotosAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FotosAdapter.FotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fotos_mascota, parent, false);

        return new FotosAdapter.FotosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final FotosAdapter.FotosViewHolder fotosViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        fotosViewHolder.imgFotoMascotaF.setImageResource(mascota.getFoto());
        fotosViewHolder.tvHardsF.setText(Integer.toString(mascota.getHards()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class FotosViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFotoMascotaF;
        private TextView tvHardsF;

        public FotosViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFotoMascotaF = (ImageView) itemView.findViewById(R.id.imgFotoMascotaF);
            tvHardsF = (TextView) itemView.findViewById(R.id.tvHardsF);
        }
    }
}
