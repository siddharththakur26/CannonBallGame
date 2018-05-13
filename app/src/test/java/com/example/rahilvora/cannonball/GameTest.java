package com.example.rahilvora.cannonball;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by siddharththakur on 13/05/18.
 */

public class GameTest {

    //hasWon() class test cases

    @Test
    public void testhasWon(){
        Game game=new Game();
        game.getBall().setPos(250,250);
        game.getCannon().pos.x=250;
        game.getCannon().pos.y=450;
        assertTrue("You won the game but you should have lost",false == game.hasWon() );
        game.getBall().setPos(250,200);
        game.getCannon().pos.x=250;
        game.getCannon().pos.y=250;
        assertTrue("You didn't win the game",true == game.hasWon() );

    }
    //gameOver() class test cases
    @Test
    public void testGameOver(){
        Game game=new Game();
        game.getBall().setPos(250,251);
        game.getCannon().pos.y =250;
        assertTrue("You should have lost the game instead you won",true == game.gameOver());
        game.getBall().setPos(960,950);
        assertTrue("You should have lost the game instead you won",true == game.gameOver());
        game.getBall().setPos(0,0);
        assertTrue("You should have lost the game instead you won",true == game.gameOver());
        game.getBall().setPos(100,250);
        game.getFires().get(0).x1posf=200;
        game.getFires().get(2).y1posf=250;
        game.getFires().get(2).x2posf=200;
        game.getFires().get(2).y2posf=300;
        assertTrue("You should have continue to play the game but something wrong happened",
                false == game.gameOver());



    }
    //ballhit() class test cases
    @Test
    public void testballhit(){
        Game game=new Game();
        game.getBall().setPos(250,250);
        game.getFires().get(0).x1posf=200;
        game.getFires().get(2).y1posf=250;
        game.getFires().get(2).x2posf=200;
        game.getFires().get(2).y2posf=300;
        assertTrue("Ball doesn't't tocuhed the fire", true == game.ballHit());
        game.getBall().setPos(100,250);
        game.getFires().get(0).x1posf=200;
        game.getFires().get(2).y1posf=250;
        game.getFires().get(2).x2posf=200;
        game.getFires().get(2).y2posf=300;
        assertTrue("Ball touched the fire", false == game.ballHit());
    }
}
