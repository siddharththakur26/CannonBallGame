package com.example.rahilvora.cannonball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by siddharththakur on 21/04/18.
 */

public class Ball extends Sprite {
    public static final float SHIPWIDTH = (1.0f / 20.0f);
    public static final float STARTX = 0.5f;
    public static final float STARTY = 0.9f;
    public static final float RADIUS = 50.0f;

    public void setPos(float x, float y) {
        pos.x = x;
        pos.y = y;
    }

    public Ball(float x, float y) {
        pos = new Position(x, y);
    }

    public void step(Bars bars, Position touch) {
        boolean falling = true;
        boolean moving = true;
        for (Bar bar: bars) {
            if (falling && (pos.x > bar.x1pos && pos.x < bar.x2pos && (pos.y + RADIUS) == bar.y1pos)) {
                falling = false;

            }

            System.out.println(touch);

            if (moving && (pos.x > bar.x1pos && pos.x < bar.x2pos && pos.y + RADIUS <= bar.y1pos)) {
                moving = false;
                if (pos.x <= touch.x) {
                    pos.x += 5.5;
                } else if (pos.x >= touch.x) {
                    pos.x -= 5.5;
                }
            }
        }
        if (falling) {
            pos.y += 5.5;
//            if (pos.x <= touch.x) {
//                pos.x += 5.5;
//            } else if (pos.x >= touch.x) {
//                pos.x -= 5.5;
//            }
        } else {

        }
    }

    public void draw(Canvas c , Paint p, Bitmap bm) {
        int h = c.getHeight();
        int w = c.getWidth();

        float xc = pos.x;
        float yc = pos.y;

        c.drawCircle(xc,yc,RADIUS,p);
    }


//    public boolean hitby(Bomb b) {
//        return (b.pos.distance(pos) < SHIPWIDTH);
//    }

}
