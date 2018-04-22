package com.example.rahilvora.cannonball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by siddharththakur on 21/04/18.
 */

public class Bar extends Sprite {

    public float x1pos;
    public float x2pos;
    public float y1pos;
    public float y2pos;
    public float speed;

    public Bar(float x1pos, float x2pos, float y1pos, float y2pos, float speed) {
        this.x1pos = x1pos;
        this.x2pos = x2pos;
        this.y1pos = y1pos;
        this.y2pos = y2pos;
        this.speed = speed;
    }

    public Bar(Position pos){
        pos=new Position(pos);
    }

    @Override
    public void draw(Canvas c, Paint p, Bitmap bm) {
        p.setColor(Color.BLUE);
        p.setStrokeWidth(15.0f);
        c.drawLine(x1pos,y1pos,x2pos,y2pos,p);
    }

}
