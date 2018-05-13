package com.example.rahilvora.cannonball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by siddharththakur on 21/04/18.
 * Bars object with number of bar as its property
 */

public class Bars extends ArrayList<Bar> {
    static float SCREENMAX = 1000.0f;
    static float SCREENMIN = 0.0f;

    //Movement of the bars are updated at every step
    public void step() {
        for (Bar b : this) {
            if (b.x2pos > SCREENMAX || b.x1pos < SCREENMIN) {
                b.speed = -1 * b.speed;
            }
            b.x1pos += b.speed;
            b.x2pos += b.speed;
        }

    }

    //Drawing the number of bars
    public void draw(Canvas canvas, Paint paint, Bitmap bm) {
        for (Bar bar : this) bar.draw(canvas, paint, bm);
    }


}
