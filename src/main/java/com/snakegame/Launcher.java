package com.snakegame;

/**
 * Created by hmoda on 28-Jul-17.
 */
public class Launcher {

    public static final String TITLE = "Snake Game v1.0";
    public static final int WIDTH = 806, HEIGHT = 455;

    public static void main(String[] args) {

        Game game = new Game();
        game.start();
    }
}
