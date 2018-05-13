package com.example.rahilvora.cannonball;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by siddharththakur on 22/04/18.
 * Fire object with it's cordinates as its property
 */

public class Fire extends Sprite {
    float x1posf;
    float x2posf;
    float y1posf;
    float y2posf;
    static float speed=20.0f;
    //Initial Position and speed of the fires is initialized
    public Fire(float x1posf, float x2posf, float y1posf, float y2posf, float speed){
        this.x1posf=x1posf;
        this.x2posf=x2posf;
        this.y1posf=y1posf;
        this.y2posf=y2posf;

    }
    //Position of fire is getting updated at every step
    public Fire(Position pos){
        pos=new Position(pos);
    }

    //Bitmap Image is drawn in the CannonBallView Class
    @Override
    public void draw(Canvas c, Paint p, Bitmap bm) {
        c.drawLine(x1posf,y1posf,x2posf,y2posf,p);

    }
}
