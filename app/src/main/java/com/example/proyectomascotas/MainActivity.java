package com.example.proyectomascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.proyectomascotas.adapter.PageAdapter;
import com.example.proyectomascotas.fragment.PerfilMascotaFragment;
import com.example.proyectomascotas.fragment.RecyclerViewFragment;
import com.example.proyectomascotas.pojo.Mascota;
import com.example.proyectomascotas.restAPI.ConstantesRestAPI;
import com.example.proyectomascotas.restAPI.IEndpointsAPI;
import com.example.proyectomascotas.restAPI.adapter.RestAPIAdapter;
import com.example.proyectomascotas.restAPI.model.UsuarioResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "NotificationIDToken";
    ArrayList<Mascota> favoritas;

    private Toolbar toolBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener( this,  new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String token = instanceIdResult.getToken();

                Log.d("Token", token);
            }
        });

        toolBar = (Toolbar) findViewById(R.id.toolBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();
    }

    private ArrayList<Fragment> agregarFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilMascotaFragment());

        return fragments;
    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.year_of_dog);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mContacto:
                Intent intentF = new Intent(this, FormularioActivity.class);

                startActivity(intentF);

                break;
            case R.id.mAcerca:
                Intent intentB = new Intent(this, BiografiaActivity.class);

                startActivity(intentB);

                break;
            case R.id.mConfigurar:
                Intent intentC = new Intent(this, ConfigurarActivity.class);

                startActivity(intentC);

                break;
            case R.id.mNotificaciones:
                FirebaseInstanceId.getInstance().getInstanceId()
                        .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                            @Override
                            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                                if (!task.isSuccessful()) {
                                    Log.w(TAG, "getInstanceId failed", task.getException());
                                    return;
                                }

                                String id_dispositivo = task.getResult().getToken();

                                enviarTokenRegistro(ConstantesRestAPI.ID_USER_INSTAGRAM, id_dispositivo);
                            }
                        });

                break;
            case R.id.mRanking:
                favoritas = new ArrayList<Mascota>();

                favoritas.add(new Mascota(R.drawable.mascota05, getResources().getString(R.string.nombre_mascota_05), 8));
                favoritas.add(new Mascota(R.drawable.mascota01, getResources().getString(R.string.nombre_mascota_01), 5));
                favoritas.add(new Mascota(R.drawable.mascota08, getResources().getString(R.string.nombre_mascota_08), 4));
                favoritas.add(new Mascota(R.drawable.mascota02, getResources().getString(R.string.nombre_mascota_02), 3));
                favoritas.add(new Mascota(R.drawable.mascota04, getResources().getString(R.string.nombre_mascota_04), 1));

                Bundle f = new Bundle();

                f.putSerializable(getResources().getString(R.string.mascotas_favoritas), (Serializable) favoritas);

                Intent intent = new Intent(this, FavoritasActivity.class);

                intent.putExtras(f);

                startActivity(intent);

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void enviarTokenRegistro(String id_usuario_instagram, String id_dispositivo) {
        Log.d(TAG, id_dispositivo);

        RestAPIAdapter restAPIAdapter = new RestAPIAdapter();
        IEndpointsAPI iEndpoints = restAPIAdapter.establecerConexionRestAPI();
        Call<UsuarioResponse> usuarioResponseCall = iEndpoints.registrarTokenID(id_usuario_instagram, id_dispositivo);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();

                Log.d("ID_FIREBASE", usuarioResponse.getId_firebase());
                Log.d("ID_DISPOSITIVO", usuarioResponse.getId_dispositivo());
                Log.d("ID_USUARIO_INSTAGRAM", usuarioResponse.getId_usuario_instagram());
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                Log.e("Error -> ", t.toString());
            }
        });
    }


}