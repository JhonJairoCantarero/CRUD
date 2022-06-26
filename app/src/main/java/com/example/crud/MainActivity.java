package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void NuevoRegistro(View view){
        Intent i = new Intent(this,NuevoRegistro.class);

        startActivity(i);
    }
    public void RegistroConsulta(View view){
        Intent i = new Intent(this,RegistrosActivity.class);

        startActivity(i);
    }
}