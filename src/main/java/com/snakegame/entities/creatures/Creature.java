package com.snakegame.entities.creatures;

import com.snakegame.Handler;
import com.snakegame.Launcher;
import com.snakegame.entities.Entity;

/**
 * Created by hmoda on 29-Jul-17.
 */
public abstract class Creature extends Entity {

    public static final int DEF_HEALTH = 3;
    public static final int DEF_SPEED = 13;
    public static final int DEF_SIDE = 13;

    //the snake has 3 hearts
    protected int health; // not used ...
    protected int speed;
    protected int xMove, yMove; //directions

    public Creature(Handler handler, int x, int y, int side) {
        super(handler, x, y, side);

        this.health = DEF_HEALTH;
        this.speed = DEF_SPEED;
        this.xMove = -1; //initial direction is to the right
        this.yMove = 0;
    }

    public void move(){
        x += xMove * speed;
        y += yMove * speed;

        //if the snake get out it will get from the other side
        if (x < 0) x = Launcher.WIDTH - Creature.DEF_SIDE;
        else if (x + Creature.DEF_SIDE > Launcher.WIDTH) x = 0;

        if (y < 0) y = Launcher.HEIGHT - Creature.DEF_SIDE;
        else if (y + Creature.DEF_SIDE > Launcher.HEIGHT) y = 0;
    }


    //GETTERS AND SETTERS
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int xSpeed) {
        this.speed = xSpeed;
    }

    public int getxMove() {
        return xMove;
    }

    public void setxMove(int xMove) {
        this.xMove = xMove;
    }

    public int getyMove() {
        return yMove;
    }

    public void setyMove(int yMove) {
        this.yMove = yMove;
    }
}
