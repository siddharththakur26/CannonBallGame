package com.example.rahilvora.cannonball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by siddharththakur on 21/04/18.
 * Ball object with it's cordinates and radius as it's behaviour
 */

public class Ball extends Sprite {
    public static final float RADIUS = 50.0f;
    public static int Score;

    //position is getting set at every movement of the ball.

    public void setPos(float x, float y) {
        pos.x = x;
        pos.y = y;

    }

    //Ball position is stored and updated at every touch movement
    public Ball(float x, float y) {
        pos = new Position(x, y);
        Score=0;
    }

    // At every step of the game, the position of the ball at every movement and falling of the ball is checked.

    public void step(Bars bars, Position touch, int touchCount) {
        boolean falling = true;
        boolean moving = true && touchCount > 0;
        for (Bar bar: bars) {
            if (falling && (pos.x > bar.x1pos && pos.x < bar.x2pos && (pos.y + RADIUS) == bar.y1pos)) {
                falling = false;

            }
            if (moving && (pos.x > bar.x1pos && pos.x < bar.x2pos && pos.y + RADIUS <= bar.y1pos)) {
                moving = false;
                if (pos.x <= touch.x) {
                    pos.x += 15.5;
                } else if (pos.x >= touch.x) {
                    pos.x -= 15.5;
                }
            }

        }
        if (falling) {
            pos.y += 13.75;
        }
        else
        {
            Score++;   // score is getting saved. Score is reset to 0 at every new game
        }
    }


    //Drawing the bitmap image of canvas
    public void draw(Canvas c , Paint p, Bitmap bm) {
        int h = c.getHeight();
        int w = c.getWidth();

        float xc = pos.x;
        float yc = pos.y;

        c.drawCircle(xc,yc,RADIUS,p);
    }

}
