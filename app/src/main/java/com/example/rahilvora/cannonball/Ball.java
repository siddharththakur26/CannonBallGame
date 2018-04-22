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

    public Ball() {
        pos = new Position(STARTX,STARTY);
    }

    public void draw(Canvas c , Paint p, Bitmap bm) {
        int h = c.getHeight();
        int w = c.getWidth();

        float xc = pos.x * w;
        float yc = pos.y * h;
        float r = SHIPWIDTH * w;

        c.drawCircle(xc,yc,50,p);
    }


//    public boolean hitby(Bomb b) {
//        return (b.pos.distance(pos) < SHIPWIDTH);
//    }

}
