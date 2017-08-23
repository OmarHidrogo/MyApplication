package com.omar_hidrogo_local.notificacionfirebase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.omar_hidrogo_local.notificacionfirebase.RestAPI.Endpoints;
import com.omar_hidrogo_local.notificacionfirebase.RestAPI.adapter.RestApiAdapter;
import com.omar_hidrogo_local.notificacionfirebase.RestAPI.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tmhidrooma on 23/08/2017.
 */

public class ToqueAnimal extends BroadcastReceiver{
    private static final String ANIMAL_RECEPTOR = "gato";
    private static final String ANIMAL_EMISOR = "perroCF";

    @Override
    public void onReceive(Context context, Intent intent) {
        String ACCION_KEY = "TOQUE_ANIMAL";
        String accion = intent.getAction();

        if(ACCION_KEY.equals(accion)){
            toqueAnimal();
            Toast.makeText(context, " Diste un toque a " + ANIMAL_RECEPTOR, Toast.LENGTH_SHORT).show();
        }

    }

    public void toqueAnimal(){
        Log.d("TOQUE_ANIMAL", "true");
        final UsuarioResponse usuarioResponse = new UsuarioResponse("-KsEMtq4X-ccOC_71D9R","123",ANIMAL_RECEPTOR);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Endpoints endpoints = restApiAdapter.establecerConexionRestAPI();
        Call<UsuarioResponse> usuarioResponseCall = endpoints.toqueanimal(usuarioResponse.getId(),ANIMAL_EMISOR);/*usuarioResponse.getAnimal());*/
        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse1 = response.body();
                Log.d("ID_FIREBASE", usuarioResponse1.getId());
                Log.d("TOKEN_FIREBASE", usuarioResponse1.getToken());
                Log.d("ANIMAL_FIREBASE", usuarioResponse1.getAnimal());
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });
    }

}
