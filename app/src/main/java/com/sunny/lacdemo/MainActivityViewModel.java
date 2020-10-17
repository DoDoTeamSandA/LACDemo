package com.sunny.lacdemo;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    public static MutableLiveData<List<Model>> list;
    public static MutableLiveData<String> teststring;
    ServerData serverData;

    public MainActivityViewModel(){
        init();
    }

    private void init() {
        teststring=new MutableLiveData<>();
        list=new MutableLiveData<>();
        new ServerData(list);


    }


    MutableLiveData<String> getString(){

        if(teststring==null){

            Random random=new Random();
            teststring=new MutableLiveData<>();

            teststring.setValue("Number"+random.nextInt(10-1)+1);

        }

        return  teststring;

    }

    void server(){
        ServerData serverData=new ServerData(list);
        serverData.getResponse();
    }


}
