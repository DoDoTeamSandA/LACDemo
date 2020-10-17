package com.sunny.lacdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("TAG", " Owner onCreate");
        getLifecycle().addObserver(new MainActivityObserver());

     MainActivityViewModel i=new MainActivityViewModel();
//        i= ViewModelProvider(this).get

        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        MutableLiveData<String> s=viewModel.getString();

        TextView textView=findViewById(R.id.TextIV);

        s.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);

            }
        });




        viewModel.server();

        viewModel.list.observe(this, new Observer<List<Model>>() {
            @Override
            public void onChanged(List<Model> models) {
                Log.i("ok", models.get(2).getTitle());
            }
        });





    }
}