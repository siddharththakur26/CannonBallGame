package com.example.rahilvora.cannonball;

/**
 * Created by siddharththakur on 21/04/18.
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

    public float distance(Position p) {
        float dx = x - p.x;
        float dy = y - p.y;
        return (float) Math.sqrt(dx*dx + dy*dy);
    }
}

