package com.example.rahilvora.cannonball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by siddharththakur on 21/04/18.
 */

public class Bars  extends ArrayList<Bar>{
    public static final float BARSTEP = 0.06f;
    float screenmax_l1=500.0f;
    float screenmax_l2=900.0f;
    float screenmax_l3=1000.0f;
    float screenmin= 0.0f;
    public void step() {
        for (Bar b : this) {
            if (b.x2pos > screenmax_l3 || b.x1pos < screenmin) {
                b.speed = -1 * b.speed;
            }
            b.x1pos += b.speed;
            b.x2pos += b.speed;
        }

    }


    public void draw(Canvas canvas, Paint paint, Bitmap bm) {
        for (Bar bar : this) bar.draw(canvas, paint, bm);
    }


}
