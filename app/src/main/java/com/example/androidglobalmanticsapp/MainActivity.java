package com.example.androidglobalmanticsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.androidglobalmanticsapp.services.MessageService;
import com.example.androidglobalmanticsapp.services.ServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView message = (TextView) findViewById(R.id.message);
        MessageService taskService = ServiceBuilder.buildServices(MessageService.class);
        Call<String> call = taskService.getMessages();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> request, Response<String> response) {
                ((TextView)findViewById(R.id.message)).setText(response.body());
            }

            @Override
            public void onFailure(Call<String> request, Throwable t) {
                ((TextView)findViewById(R.id.message)).setText("Request Failed");
            }
        });
    }
    public void GetStarted(View view){
        Intent intent = new Intent(this, IdeaListActivity.class);
        startActivity(intent);
    }
}