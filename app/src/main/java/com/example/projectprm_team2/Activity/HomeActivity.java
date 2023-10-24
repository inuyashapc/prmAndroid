package com.example.projectprm_team2.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectprm_team2.R;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }
    @Override
    protected void onRestart() {
        super.onRestart();

    }


    @Override
    protected void onResume() {
        super.onResume();
        //setProFile();
    }

}
