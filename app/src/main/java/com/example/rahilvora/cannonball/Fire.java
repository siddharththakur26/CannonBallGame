package com.example.rahilvora.cannonball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by siddharththakur on 22/04/18.
 */

public class Fire extends Sprite {
    float x1posf;
    float x2posf;
    float y1posf;
    float y2posf;
    public Fire(Position pos){
        pos=new Position(pos);
    }

    @Override
    public void draw(Canvas c, Paint p, Bitmap bm) {
        c.drawLine(x1posf,y1posf,x2posf,y2posf,p);

    }
}
