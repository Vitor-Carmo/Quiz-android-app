package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowScoreActivity extends AppCompatActivity {
    TextView TxtScore;
    TextView TxtStatus;
    MediaPlayer audio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        TxtScore = findViewById(R.id.txtscore);
        TxtStatus = findViewById(R.id.txtStatus);
        Intent intent = getIntent();
        String scores = String.valueOf(intent.getIntExtra("score", 0));

        TxtScore.setText(scores);
        TxtStatus.setText(setStatus(scores));
        audio.start();
    }

    private String setStatus(String scores){
        int score = Integer.parseInt(scores);

        if(score >= 8){
            audio = MediaPlayer.create(this, R.raw.high_score);
            return "Você é muito inteligente!";
        }

        if (score >= 5){
            audio = MediaPlayer.create(this,  R.raw.medium_score);
            return "Parabéns!";
        }

        audio = MediaPlayer.create(this,  R.raw.low_score);
        return "Você precisa estudar mais...";

    }


    public void goToHome(View v){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
        finish();
    }

}
