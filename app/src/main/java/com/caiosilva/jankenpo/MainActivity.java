package com.caiosilva.jankenpo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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

        System.out.println(userChoice);

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int randAppChoice = new Random().nextInt(3);
        String escolhaApp = opcoes[randAppChoice];

        switch (escolhaApp) {
            case "Pedra":
                break;
            case "Papel":
                break;
            case "Tesoura":
                break;
        }

        System.out.println("App escolheu " + escolhaApp);
    }

    public void selectStone() {
        this.optionSelected("Voce escolheu Pedra");
    }

    public void selectPaper() {
        this.optionSelected("Voce escolheu Papel");
    }

    public void selectScissors() {
        this.optionSelected("Voce escolheu Tesoura");
    }
}
