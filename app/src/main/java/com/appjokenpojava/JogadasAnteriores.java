package com.appjokenpojava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JogadasAnteriores extends AppCompatActivity {

    private DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference jogadasReferencia = databaseReferencia.child("ultimasJogadas");

    ListView listaJogadas;
    ProgressBar carregamentoJogadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogadas_anteriores);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Últimas Jogadas");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.corBarraTitulo)));

        listaJogadas = findViewById(R.id.listaJogadasId);
        carregamentoJogadas = findViewById(R.id.carregamentoJogadasId);

        listaJogadas.setVisibility(View.INVISIBLE);
        carregamentoJogadas.setVisibility(View.VISIBLE);

        final ArrayList<String> listaDeDados = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaDeDados);

        jogadasReferencia.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                List<String> ultimasJogadas = new ArrayList<>();

                if(!dataSnapshot.exists()){

                    listaDeDados.add("Nenhuma jogada encontrada.");

                }else{

                    for(DataSnapshot dados: dataSnapshot.getChildren()){
                        ultimasJogadas.add(dados.getValue().toString());
                    }

                    Collections.reverse(ultimasJogadas);
                    String[] arrayDeDados = ultimasJogadas.toArray(new String[ultimasJogadas.size()]);

                    for (int contador = 0; contador < arrayDeDados.length; contador++){
                        listaDeDados.add(arrayDeDados[contador]);
                    }

                }

                adapter.notifyDataSetChanged();
                listaJogadas.setAdapter(adapter);

                listaJogadas.setVisibility(View.VISIBLE);
                carregamentoJogadas.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}

        });
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
