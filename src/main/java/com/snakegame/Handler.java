package com.snakegame;

import com.snakegame.entities.items.Food;
import com.snakegame.input.KeyManager;
import com.snakegame.input.MouseManager;
import com.snakegame.states.GameOverState;
import com.snakegame.states.GameState;
import com.snakegame.states.MenuState;

/**
 * Created by hmoda on 31-Jul-17.
 */
public class Handler {

    private Food food;
    private Game game;

    public Handler(Game game) {
        this.game = game;
    }

    //States to switch for

    public GameState getGameState(){ return (GameState) this.game.getGameState(); }

    public GameOverState getGameOverState() { return (GameOverState) this.game.getGameOverState(); }

    public MenuState getMenuState() { return (MenuState) this.game.getMenuState(); }

    //Input Managers
    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }


    //Food!!
    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    //Game!!
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
