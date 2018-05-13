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

import java.util.ArrayList;

/**
 * Created by siddharththakur on 22/04/18.
 */

public class CannonBallView  extends View implements View.OnTouchListener, Runnable {
    public static final int STEPDELAY = 100;
    public static final int DEFAULTCOLOUR = Color.BLACK;
    public static final float DEFAULTPENWIDTH = 3.0f;
    private  float xposc_touch;
    private float yposc_touch;

    public static int getTouchCount() {
        return touchCount;
    }

    public static void setTouchCount(int touchCount) {
        CannonBallView.touchCount = touchCount;
    }

    private static int touchCount;
    Paint paint;
    Handler repaintHandler;
    Game game;
    Bitmap bm;
    ArrayList<GameOver> observers ;

    //CannonBallView constructor is called and initialize bars,ball,fires and cannon in the view.
    public CannonBallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(DEFAULTCOLOUR);
        paint.setStrokeWidth(DEFAULTPENWIDTH);
        this.setOnTouchListener(this);
        game = new Game();
        setTouchCount(0);
        bm= BitmapFactory.decodeResource(getResources(),R.drawable.funnel);
        game.setCannonDim(bm.getWidth(), bm.getHeight());
        repaintHandler = new Handler();
        repaintHandler.postDelayed(this, STEPDELAY);
        observers=new ArrayList<GameOver>();
    }

    //Storing the touch movements
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
            xposc_touch = motionEvent.getX();
            yposc_touch = motionEvent.getY();
            this.invalidate();
            setTouchCount(getTouchCount() + 1);
        }
        return true;
    }

    // step the view forward by one step - true is returned if more steps to go
    public boolean step() {
        Position pos = new Position(xposc_touch, yposc_touch);
        game.step(pos);
        if (game.hasWon() || game.ballHit() || game.gameOver()) {
            notifyGameOver();
            return false;
        }
        this.invalidate();
        return true;
    }
    //Drawing the canvas on the view.
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        game.draw(canvas, paint, bm );
    }



    @Override
    public void run() {
        if (step()) {
            repaintHandler.postDelayed(this, CannonBallView.STEPDELAY);
        }



    }
    //notify when the game gets over
    private void notifyGameOver() {
        for (GameOver o : observers)
            o.gameOver(game.hasWon());
    }


    //register the event when the game is over.
    public void registerGameOver(GameOver gameover) {
        observers.add(gameover);
    }
}
