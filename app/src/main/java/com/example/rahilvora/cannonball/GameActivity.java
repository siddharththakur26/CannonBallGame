package com.example.rahilvora.cannonball;

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

    //Message is displayed when the game is won or lost.
    @Override
    public void gameOver(boolean b) {
        if (b) {
            Toast.makeText(getApplicationContext(), "Cool! You Won >> Your Score is: "+Ball.Score, Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Opps! You Lost >> Your Score is :" + Ball.Score/10, Toast.LENGTH_LONG).show();
        }
        setResult(AppCompatActivity.RESULT_OK);
        finish();
    }
}
