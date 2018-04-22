package com.example.rahilvora.cannonball;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by siddharththakur on 22/04/18.
 */

public class Cannon extends Sprite {

    public Cannon(float x, float y) {
        pos = new Position(x, y);
    }


    public void draw(Canvas c, Paint p, Bitmap bm) {
        c.drawBitmap(bm,pos.x,pos.y,p);
    }
}
