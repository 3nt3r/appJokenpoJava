package com.appjokenpojava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

public class JogadasAnteriores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogadas_anteriores);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Últimas Jogadas");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.corBarraTitulo)));








    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                finishAffinity();
                break;
            default:
                break;
        }
        return true;
    }

}
