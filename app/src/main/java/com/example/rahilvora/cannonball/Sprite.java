package com.example.rahilvora.cannonball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by siddharththakur on 21/04/18.
 * Base Class where every object inherits for their property
 */

public abstract class Sprite {
        Position pos;
        public abstract void draw(Canvas c, Paint p, Bitmap bm);
    }


