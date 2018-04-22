package com.example.rahilvora.cannonball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by siddharththakur on 22/04/18.
 */

public class Fires extends ArrayList<Fire>{
    public static final float FIRESTEP = 0.03f;

    public void step() {
        for (Fire f : this) f.pos.y += FIRESTEP;
        Iterator<Fire> fi = this.iterator();
        while (fi.hasNext()) {
            Fire f = fi.next();
            if (f.pos.y > Game.MAXXY) fi.remove();
        }
    }

    public void draw(Canvas canvas, Paint paint, Bitmap bm) {
        for (Fire f : this) f.draw(canvas, paint, bm);
    }

}
