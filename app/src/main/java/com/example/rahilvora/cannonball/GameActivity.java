package com.example.rahilvora.cannonball;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity implements GameOver {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
     CannonBallView cannonBallView= findViewById(R.id.cannon_view);
      cannonBallView.registerGameOver(this);
    }


    @Override
    public void gameOver() {
        setResult(AppCompatActivity.RESULT_OK);
        finish();
    }
}
