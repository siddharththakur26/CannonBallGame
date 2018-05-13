package com.example.rahilvora.cannonball;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by siddharththakur on 22/04/18.
 * Cannon Image object with its cordinates as its property.
 */

public class Cannon extends Sprite {

    float x_screensize = 900.0f;
    float speed = 10.0f;

    //Initial Position of the Cannon is initialized
    public Cannon(float x, float y) {
        pos = new Position(x, y);
    }

    //Speed of the movement of the cannon is updated at every step
    public void step() {
        if (pos.x >= x_screensize || pos.x < 0){
            speed = -1 * speed;
        }
        pos.x += speed;

    }

    //Drawing the Canvas in CannonBallView class
    public void draw(Canvas c, Paint p, Bitmap bm) {
        c.drawBitmap(bm,pos.x,pos.y,p);
    }
}
