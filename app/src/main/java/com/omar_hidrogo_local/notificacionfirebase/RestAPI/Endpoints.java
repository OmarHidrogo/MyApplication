package com.omar_hidrogo_local.notificacionfirebase.RestAPI;

import com.omar_hidrogo_local.notificacionfirebase.RestAPI.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by tmhidrooma on 11/08/2017.
 */

public interface Endpoints {

    @FormUrlEncoded
    @POST(ConstanteRestAPI.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenID(@Field("token")String token/*, @Field("animal")String animal*/);

}
