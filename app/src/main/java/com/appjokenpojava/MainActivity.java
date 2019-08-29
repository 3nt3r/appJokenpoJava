package com.appjokenpojava;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private Button botaoPapel;
    private Button botaoPedra;
    private Button botaoTesoura;
    private Button botaoUltimasJogadas;

    private EditText textoResultado;

    private ImageView imagemComputador;
    private ImageView imagemJogador;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
