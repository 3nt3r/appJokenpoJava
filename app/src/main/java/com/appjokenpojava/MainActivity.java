package com.appjokenpojava;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.Random;

public class MainActivity extends Activity {

    Random random = new Random();

    private Button botaoPapel;
    private Button botaoPedra;
    private Button botaoTesoura;
    private Button botaoUltimasJogadas;
    private TextView textoResultado;
    private ImageView imagemComputador;
    private ImageView imagemJogador;
    private TextView textoComputador;
    private TextView textoVoce;

    String escolhaUsuario = "";
    String escolhaComputador = "";
    String resultado = "";

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void jokenpo(String usuario){

        escolhaUsuario = usuario;

        textoComputador.setVisibility(View.VISIBLE);
        textoVoce.setVisibility(View.VISIBLE);
        textoResultado.setVisibility(View.VISIBLE);

        int numeroAleatorio = random.nextInt(3);

        if (numeroAleatorio == 0){
            escolhaComputador = "Pedra";
            imagemComputador.setBackground(getResources().getDrawable(R.drawable.pedra));
        }else if (numeroAleatorio == 1){
            escolhaComputador = "Papel";
            imagemComputador.setBackground(getResources().getDrawable(R.drawable.papel));
        }else{
            escolhaComputador = "Tesoura";
            imagemComputador.setBackground(getResources().getDrawable(R.drawable.tesoura));
        }

        if (usuario == "Pedra"){
            imagemJogador.setBackground(getResources().getDrawable(R.drawable.pedra));
        }else if (usuario == "Papel"){
            imagemJogador.setBackground(getResources().getDrawable(R.drawable.papel));
        }else{
            imagemJogador.setBackground(getResources().getDrawable(R.drawable.tesoura));
        }

        if (numeroAleatorio == 0) {
            if (usuario == "Pedra") {
                resultado = "Empate";
            }else if (usuario == "Papel") {
                resultado = "Você Venceu";
            }else{
                resultado = "Você Perdeu";
            }
        }

        if (numeroAleatorio == 1) {
            if (usuario == "Pedra") {
                resultado = "Você Perdeu";
            }else if (usuario == "Papel") {
                resultado = "Empate";
            }else{
                resultado = "Você Venceu";
            }
        }

        if (numeroAleatorio == 2) {
            if (usuario == "Pedra") {
                resultado = "Você Venceu";
            }else if (usuario == "Papel") {
                resultado = "Você Perdeu";
            }else{
                resultado = "Empate";
            }
        }

        textoResultado.setText(resultado);

        if(resultado == "Você Venceu"){
            Vibrator vibrar = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrar.vibrate(500);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoResultado = findViewById(R.id.textoResultadoId);

        imagemJogador = findViewById(R.id.imagemJogadorId);
        imagemComputador = findViewById(R.id.imagemComputadorId);

        textoComputador = findViewById(R.id.textoComputadorId);
        textoVoce = findViewById(R.id.textoVoceId);


        textoComputador.setVisibility(View.INVISIBLE);
        textoVoce.setVisibility(View.INVISIBLE);
        textoResultado.setVisibility(View.INVISIBLE);

        botaoPedra = findViewById(R.id.botaoPedraId);
        botaoPedra.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                jokenpo("Pedra");
            }
        });

        botaoPapel = findViewById(R.id.botaoPapelId);
        botaoPapel.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                jokenpo("Papel");
            }
        });

        botaoTesoura = findViewById(R.id.botaoTesouraId);
        botaoTesoura.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                jokenpo("Tesoura");
            }
        });

    }
}
