package com.example.proyectomascotas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectomascotas.db.ConstructorMascotas;
import com.example.proyectomascotas.pojo.Mascota;
import com.example.proyectomascotas.R;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;
    private int hard;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgFotoMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreMascota.setText(mascota.getNombre());
        mascotaViewHolder.tvHards.setText(Integer.toString(mascota.getHards()));

        mascotaViewHolder.imgLikeMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);

                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvHards.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));

                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFotoMascota;
        private TextView tvNombreMascota;
        private TextView tvHards;
        private ImageView imgLikeMascota;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFotoMascota = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvHards = (TextView) itemView.findViewById(R.id.tvHards);
            imgLikeMascota = (ImageView) itemView.findViewById(R.id.imgLikeMascota);
        }
    }
}
