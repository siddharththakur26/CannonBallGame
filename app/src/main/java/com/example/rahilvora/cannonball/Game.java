package com.example.rahilvora.cannonball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by siddharththakur on 21/04/18.
 * Game Class where Bars, Fires, Ball and Cannon are drawn. Status of the game is checked and updated.
 */

public class Game {

    public static final float SCREENSIZE = 1000.0f;
    private Bars bars;
    private Cannon cannon;
    private Fires fires;
    private Ball ball;

    public Bars getBars() {
        return bars;
    }

    public Cannon getCannon() {
        return cannon;
    }

    public Ball getBall() {
        return ball;
    }


    public Fires getFires() {
        return fires;
    }

    public float getCannonWidth() {
        return cannonWidth;
    }

    public void setCannonWidth(float cannonWidth) {
        this.cannonWidth = cannonWidth;
    }

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


        // Adding bars
        bars.add(new Bar(0.f, 300.f, 100.0f, 100.f, 5));
        bars.add(new Bar(0.f, 450.f, 375.0f, 375.f, 10));
        bars.add(new Bar(0.f, 550.f, 650.0f, 650.f, 15));


        // Adding fires
        fires.add(new Fire(0.f, 50.f, 925.0f, 925.f, 15));
        fires.add(new Fire(60.f, 110.f, 925.0f, 925.f, 15));
        fires.add(new Fire(120.f, 170.f, 925.0f, 925.f, 15));
    }

    // draw all objects of the game in the CannonBallView
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
    //Return true if user won the game
    public boolean hasWon() {
        if (ball.pos.x >= cannon.pos.x - cannonWidth && ball.pos.x <= cannon.pos.x + cannonWidth &&
                ball.pos.y + Ball.RADIUS >= cannon.pos.y)
            return true;
        return false;
    }

    //return true if the User fails to win the game

    public boolean gameOver(){
        if (ball.pos.y > cannon.pos.y) {
            return true;
        }

        else if (ball.pos.x + ball.RADIUS > SCREENSIZE || ball.pos.x-ball.RADIUS < 0)
            return true;

        else if (ballHit())
            return true;

        return false;
    }


    //return true when ball hits the fires
    public boolean ballHit() {
        if ((ball.pos.y + ball.RADIUS > this.fires.get(2).y1posf) && (ball.pos.y - ball.RADIUS < this.fires.get(2).y2posf) ) {
            if (this.fires.get(0).x1posf <= (ball.pos.x + ball.RADIUS) && this.fires.get(2).x2posf >= (ball.pos.x - ball.RADIUS))
                return true;
        }
        return false;

    }


}


