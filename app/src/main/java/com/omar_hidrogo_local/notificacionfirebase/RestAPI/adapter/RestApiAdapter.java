package com.omar_hidrogo_local.notificacionfirebase.RestAPI.adapter;

import com.omar_hidrogo_local.notificacionfirebase.RestAPI.ConstanteRestAPI;
import com.omar_hidrogo_local.notificacionfirebase.RestAPI.Endpoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tmhidrooma on 11/08/2017.
 */

public class RestApiAdapter {

    public Endpoints establecerConexionRestAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstanteRestAPI.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Endpoints.class);
    }
}
