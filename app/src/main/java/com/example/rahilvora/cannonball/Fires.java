package com.example.rahilvora.cannonball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by siddharththakur on 22/04/18.
 * Fires object with number of Fire as its property
 */

public class Fires extends ArrayList<Fire> {
    public static final float FIRESTEP = 0.03f;
    public static float SCREENMAX = 1000.0f;
    public static float SCREENMIN = 0.0f;
    //Movement of fire is updated at every step
    public void step() {
        if (this.get(2).x2posf > SCREENMAX || this.get(0).x1posf < SCREENMIN) {
            Fire.speed = -1 * Fire.speed;
        }
        for (Fire f : this) {
            f.x1posf += f.speed;
            f.x2posf += f.speed;

        }
    }
    //Drawing a line of fire on the CannonBallView
    public void draw(Canvas canvas, Paint paint, Bitmap bm) {
        for (Fire f : this) f.draw(canvas, paint, bm);
    }

}
