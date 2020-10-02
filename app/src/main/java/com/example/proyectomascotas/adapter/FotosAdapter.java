package com.example.proyectomascotas.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectomascotas.R;
import com.example.proyectomascotas.pojo.Mascota;
import com.example.proyectomascotas.restAPI.IEndpointsAPI;
import com.example.proyectomascotas.restAPI.adapter.RestAPIAdapter;
import com.example.proyectomascotas.restAPI.model.LikeResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FotosAdapter extends RecyclerView.Adapter<FotosAdapter.FotosViewHolder> {
    private static final String TAG = "NotificationLikeFoto";
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

        //fotosViewHolder.imgFotoMascotaF.setImageResource(mascota.getFoto());

        Picasso.get()
                .load(mascota.getFotoP())
                .into(fotosViewHolder.imgFotoMascotaF);

        fotosViewHolder.tvHardsF.setText(Integer.toString(mascota.getHards()));

        fotosViewHolder.imgHardMascotaF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int likes = mascota.getHards() + 1;

                mascota.setHards(likes);
                fotosViewHolder.tvHardsF.setText(Integer.toString(mascota.getHards()));

                FirebaseInstanceId.getInstance().getInstanceId()
                        .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                            @Override
                            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                                if (!task.isSuccessful()) {
                                    Log.w(TAG, "getInstanceId failed", task.getException());
                                    return;
                                }

                                String id_dispositivo = task.getResult().getToken();

                                enviarLikeRegistro(view, mascota.getIdP(), mascota.getNombre(), id_dispositivo);
                            }
                        });
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class FotosViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFotoMascotaF;
        private TextView tvHardsF;
        private ImageView imgHardMascotaF;

        public FotosViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFotoMascotaF = (ImageView) itemView.findViewById(R.id.imgFotoMascotaF);
            tvHardsF = (TextView) itemView.findViewById(R.id.tvHardsF);
            imgHardMascotaF = (ImageView) itemView.findViewById(R.id.imgHardMascotaF);
        }
    }

    private void enviarLikeRegistro(View view, String id_foto_instagram, String id_usuario_instagram, String id_dispositivo) {
        RestAPIAdapter restAPIAdapter = new RestAPIAdapter();
        IEndpointsAPI iEndpointsAPI = restAPIAdapter.establecerConexionRestAPI();
        Call<LikeResponse> likeResponseCall = iEndpointsAPI.registrarLike(id_foto_instagram, id_usuario_instagram, id_dispositivo);

        likeResponseCall.enqueue(new Callback<LikeResponse>() {
            @Override
            public void onResponse(Call<LikeResponse> call, Response<LikeResponse> response) {
                LikeResponse likeResponse = response.body();

                Log.d("ID_FIREBASE", likeResponse.getId_firebase());
                Log.d("ID_FOTO_INSTAGRAM", likeResponse.getId_foto_instagram());
                Log.d("ID_USUARIO_INSTAGRAM", likeResponse.getId_usuario_instagram());
                Log.d("ID_DISPOSITIVO", likeResponse.getId_dispositivo());

                Toast.makeText(view.getContext(), "Like registrado con exito en FireBase", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LikeResponse> call, Throwable t) {
                Log.e("Error -> ", t.toString());
            }
        });
    }
}
