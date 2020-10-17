package com.sunny.lacdemo;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MainActivityObserver  implements LifecycleObserver {

    private   String TAG=this.getClass().getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public static void onCrateEvent(){
        Log.i("TAG", "Observer On_Create ");
    }




}

