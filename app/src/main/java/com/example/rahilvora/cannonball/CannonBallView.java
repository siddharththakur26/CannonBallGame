package com.example.rahilvora.cannonball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import android.os.Handler;
/**
 * Created by siddharththakur on 22/04/18.
 */

public class CannonBallView  extends View implements View.OnTouchListener, Runnable {
    public static final int STEPDELAY = 100;
    public static final int DEFAULTCOLOUR = Color.BLACK;
    public static final float DEFAULTPENWIDTH = 3.0f;
    private  float xposc_touch;
    private float yposc_touch;
    Paint paint;
    Handler repaintHandler;
    Game game;
    Bitmap bm;

    public CannonBallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(DEFAULTCOLOUR);
        paint.setStrokeWidth(DEFAULTPENWIDTH);
        this.setOnTouchListener(this);
        game = new Game();
        Ball b=new Ball();
        bm= BitmapFactory.decodeResource(getResources(),R.drawable.funnel);
        repaintHandler = new Handler();
        repaintHandler.postDelayed(this, STEPDELAY);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
            xposc_touch = motionEvent.getX();
            yposc_touch = motionEvent.getY();
            this.invalidate();
        }
        return true;
    }

    // step the view forward by one step - true is returned if more steps to go
    public boolean step() {
        game.step();
        if (game.hasWon() || game.ballHit()) {
           /* Context context = this.getContext();
            while (!(context instanceof GameActivity))
                context = ((GameActivity) context).getBaseContext();
            ((GameActivity) context).endActivity(game.hasWon() ? "You Win !!" : "You Lost :(");*/
//            notifyGameOver();
            return false;
        }
        this.invalidate();
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        game.draw(canvas, paint, bm );
    }


//    private void notifyGameOver() {
//        for (GameOver o : observers) o.gameOver();
//    }


    @Override
    public void run() {
        if (step()) {
            repaintHandler.postDelayed(this, CannonBallView.STEPDELAY);
        }



    }

}