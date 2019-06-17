package com.caiosilva.jankenpo;

import android.support.v7.app.AppCompatActivity;
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

        ImageView pedra = findViewById(R.id.rockChoiceImageView);
        ImageView papel = findViewById(R.id.paperChoiceImageView);
        ImageView tesoura = findViewById(R.id.scissorsChoiceImageView);

        pedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectStone();
            }
        });

        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPaper();
            }
        });

        tesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectScissors();
            }
        });

    }

    public void optionSelected(String userChoice) {

        ImageView appChoice = findViewById(R.id.appChoiceImageView);
        TextView result = findViewById(R.id.playerResult);

        System.out.println(userChoice);

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int randAppChoice = new Random().nextInt(3);
        String escolhaApp = opcoes[randAppChoice];

        switch (escolhaApp) {
            case "Pedra":
                appChoice.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                appChoice.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                appChoice.setImageResource(R.drawable.tesoura);
                break;
        }

        if((escolhaApp.equals("Pedra") && userChoice.equals("Tesoura")) ||
                (escolhaApp.equals("Papel") && userChoice.equals("Pedra")) ||
                (escolhaApp.equals("Tesoura") && userChoice.equals("Papel"))) {
            result.setText(R.string.result_lost);
            System.out.println("App Ganhou");
        } else if((escolhaApp.equals( "Tesoura") && userChoice.equals("Pedra")) ||
                (escolhaApp.equals("Papel") && userChoice.equals("Tesoura")) ||
                (escolhaApp.equals("Pedra") && userChoice.equals("Papel"))) {
            result.setText(R.string.result_win);
            System.out.println("Jogador Ganhou");
        } else {
            System.out.println("Empate");
            result.setText(R.string.result_draw);
        }

        System.out.println("App escolheu " + escolhaApp);
    }

    public void selectStone() {
        this.optionSelected("Pedra");
    }

    public void selectPaper() {
        this.optionSelected("Papel");
    }

    public void selectScissors() {
        this.optionSelected("Tesoura");
    }
}
