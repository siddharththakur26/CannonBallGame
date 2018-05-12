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
    public static final float SCREENSIZE = 1000.0f;


    public static final float MISSILESTEP = 0.06f;


    private Bars bars;
    private Cannon cannon;
    private Fires fires;
    private Ball ball;
    private Fire fp;

//    private boolean ballHit;

    private float cannonWidth;
    private float cannonHeight;

    public void setCannonDim(float cannonWidth, float cannonHeight) {
        this.cannonWidth = cannonWidth;
        this.cannonHeight = cannonHeight;
    }

    public Game() {

        bars = new Bars();
        ball = new Ball(200, 50); // x1pos + 200, y1pos - 50 from bar 1
        fires = new Fires();
        cannon= new Cannon(500, 1000);


        // Adding new bar in bars
        bars.add(new Bar(0.f, 300.f, 100.0f, 100.f, 5));
        bars.add(new Bar(0.f, 450.f, 375.0f, 375.f, 10));
        bars.add(new Bar(0.f, 550.f, 650.0f, 650.f, 15));
      //  BallHit = false;

        // Adding a fire
        fires.add(new Fire(0.f, 50.f, 925.0f, 925.f, 15));
        fires.add(new Fire(60.f, 110.f, 925.0f, 925.f, 15));
        fires.add(new Fire(120.f, 170.f, 925.0f, 925.f, 15));
    }

    // draw all the game
    public void draw(Canvas canvas, Paint paint, Bitmap bm) {
        bars.draw(canvas, paint, bm);
        cannon.draw(canvas,paint,bm);
        ball.draw(canvas, paint, bm);
        fires.draw(canvas,paint,bm);


    }

    // move the game forward one step
    public void step(Position pos) {

        bars.step();
        cannon.step();
        ball.step(bars, pos, CannonBallView.getTouchCount());
        fires.step();

    }

    public boolean hasWon() {
        if (ball.pos.x >= cannon.pos.x && ball.pos.x <= cannon.pos.x + cannonWidth && ball.pos.y + Ball.RADIUS == cannon.pos.y)
            return true;

        return false;
    }

    //return true if the ball crossess the screen and pass beyond the cannon

    public boolean gameOver(){
        if (ball.pos.y > cannon.pos.y) {
                return true;
        }
        else if (ball.pos.x > SCREENSIZE || ball.pos.x-ball.RADIUS < 0)
            return true;

        else if (ballHit())
            return true;

        return false;
    }

    public boolean ballHit() {
        if ((ball.pos.y + ball.RADIUS > this.fires.get(2).y1posf) && (ball.pos.y - ball.RADIUS < this.fires.get(2).y2posf) ) {
            if (this.fires.get(0).x1posf <= (ball.pos.x + ball.RADIUS) && this.fires.get(2).x2posf >= (ball.pos.x - ball.RADIUS))
                return true;
        }
        return false;

    }


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


