package com.example.rahilvora.cannonball;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements GameOver {
    private CannonBallView cannonBallView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
      cannonBallView= findViewById(R.id.cannon_view);
      cannonBallView.registerGameOver(this);
    }
    @Override
    public void gameOver() {
        if (cannonBallView.game.hasWon()) {
            Toast.makeText(getApplicationContext(), "Cool! You Won", Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), "Your Score is :" + Ball.Score, Toast.LENGTH_SHORT).show();
        }
        else if (cannonBallView.game.gameOver()) {
            Toast.makeText(getApplicationContext(), "Opps! You Lost || Your Score is :" + Ball.Score, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), "Your Score is :" + Ball.Score, Toast.LENGTH_SHORT).show();
        }
        setResult(AppCompatActivity.RESULT_OK);
        finish();
    }
}
