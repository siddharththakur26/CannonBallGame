package com.example.rahilvora.cannonball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by siddharththakur on 21/04/18.
 */

public abstract class Sprite {
        Position pos;
        public abstract void draw(Canvas c, Paint p, Bitmap bm);
    }


