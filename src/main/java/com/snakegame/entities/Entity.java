package com.snakegame.entities;

import com.snakegame.Game;
import com.snakegame.Handler;

import java.awt.*;

/**
 * Created by hmoda on 29-Jul-17.
 */
public abstract class Entity {

    protected Handler handler;

    protected int x, y;
    protected int side;//because its a square

    public Entity(Handler handler, int x, int y, int side) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.side = side;
    }

    public abstract void tick();
    public abstract void render(Graphics g);


    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
