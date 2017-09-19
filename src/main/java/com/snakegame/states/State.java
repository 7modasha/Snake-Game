package com.snakegame.states;

import com.snakegame.Game;
import com.snakegame.Handler;

import java.awt.*;

/**
 * Created by hmoda on 29-Jul-17.
 */
public abstract class State {

    //State Manager
    //Holds the current state and set it and get it.
    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    //---------------------------------------
    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    //methods to override
    public abstract void tick();
    public abstract void render(Graphics g);
}
