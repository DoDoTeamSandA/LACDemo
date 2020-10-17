package com.sunny.lacdemo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerData {
    MutableLiveData<List<Model>> list;

    public ServerData(MutableLiveData<List<Model>> list){

        this.list=list;

    }
    public void getResponse() {

        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        Repo client=retrofit.create(Repo.class);

        Call<List<Model>> call=client.getdata();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                Log.i("TAG",""+ response.body().get(1).getBody());

                list.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.i("TAG", "onFailure: "+t.getMessage());

            }
        });


    }
    }




