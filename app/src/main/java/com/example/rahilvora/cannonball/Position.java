package com.example.rahilvora.cannonball;

/**
 * Created by siddharththakur on 21/04/18.
 * Position object with its property as X and Y cordinates
 */

public class Position {
    float x;
    float y;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position p) {
        this.x = p.x;
        this.y = p.y;
    }

    //to view the value of X cordinates and Y cordinates
    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }
}


