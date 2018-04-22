package com.example.rahilvora.cannonball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by siddharththakur on 21/04/18.
 */

public class Game {

    public static final float MAXXY = 1.0f;
    public static final float MINXY = 0.0f;


    public static final float MISSILESTEP = 0.06f;


    private Bars bars;
    private Cannon cannon;
    private Fires fires;
    private Ball ball;

    private boolean ballHit;


    public Game() {

        bars = new Bars();
        ball = new Ball();
        fires = new Fires();
        cannon= new Cannon(500, 1000);


        // Adding new bar in bars
        bars.add(new Bar(0.f, 300.f, 100.0f, 100.f, 5));
        bars.add(new Bar(0.f, 450.f, 375.0f, 375.f, 10));
        bars.add(new Bar(0.f, 550.f, 650.0f, 650.f, 15));
      //  BallHit = false;
    }

    // draw all the game
    public void draw(Canvas canvas, Paint paint, Bitmap bm) {
        bars.draw(canvas, paint, bm);
        cannon.draw(canvas,paint,bm);


    }

    // move the game forward one step
    public void step() {

        bars.step();

    }

    public boolean hasWon() {
        //return !ballHit && ball == 0;
        return false;
    }

    public boolean ballHit() {
        return ballHit;
    }

//    public boolean hasWon() {
//        return !shipHit && aliens.size() == 0;
//    }
//
//    public boolean shipHit() {
//        return shipHit;
//    }
//
//    public void touch(float xpos) {
//        spaceShip.pos.x = xpos;
//        missiles.add(new Missile(spaceShip.pos));
    // }

}


