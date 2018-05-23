package com.example.yeajunseoked.mynewapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class OostoreActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oostore);

        Button button = (Button) findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /*Intent intent = getIntent();
        processIntent(intent);*/
    }
    /*public void processIntent(Intent intent) {
        if(intent != null){
            ArrayList<String> names = (ArrayList<String>) intent.getSerializableExtra("names");
            Toast.makeText(getApplicationContext(), "전달받은 값 :"+ names.get(0), Toast.LENGTH_LONG).show();
        }
    }*/
}
