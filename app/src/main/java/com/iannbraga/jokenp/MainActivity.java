package com.iannbraga.jokenp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionouPedra(View view){

        this.opcaoSelecionada("Pedra");
    }

    public void selecionouPapel(View view){

        this.opcaoSelecionada("Papel");
    }

    public void selecionouTesoura(View view){

        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoUsuario){

        ImageView jogadaApp = findViewById(R.id.imgJogadaApp);
        ImageView jogadaUsuario = findViewById(R.id.imgJogadaUsuario);
        TextView resultado = findViewById(R.id.txtResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};

        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "Pedra":
                jogadaApp.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                jogadaApp.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                jogadaApp.setImageResource(R.drawable.tesoura);
                break;
        }

        switch (opcaoUsuario){
            case "Pedra":
                jogadaUsuario.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                jogadaUsuario.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                jogadaUsuario.setImageResource(R.drawable.tesoura);
                break;
        }

        if(opcaoApp == "Tesoura" && opcaoUsuario == "Papel"
            || opcaoApp == "Pedra" && opcaoUsuario == "Tesoura"
                || opcaoApp == "Papel" && opcaoUsuario == "Pedra"){//App ganhador

            resultado.setText("Você perdeu!!");

        }else if(opcaoUsuario == "Tesoura" && opcaoApp == "Papel"
                    || opcaoUsuario == "Papel" && opcaoApp == "Pedra"
                        || opcaoUsuario == "Pedra" && opcaoApp == "Tesoura"){//Usuario ganhador
            resultado.setText("Você ganhou!!");

        }else{//Empate

            resultado.setText("Empate");
        }

    }
}
