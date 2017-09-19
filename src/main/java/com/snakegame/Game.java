package com.snakegame;

import com.snakegame.display.Display;
import com.snakegame.gfx.Assets;
import com.snakegame.input.KeyManager;
import com.snakegame.input.MouseManager;
import com.snakegame.states.GameOverState;
import com.snakegame.states.GameState;
import com.snakegame.states.MenuState;
import com.snakegame.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by hmoda on 28-Jul-17.
 */
public class Game implements Runnable{

    private Display display;

    private Thread thread;
    private boolean running = false;

    //Graphics for drawing
    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    private State menuState;
    private State gameOverState;

    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //Handler
    private Handler handler;

    public Game() {
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init() {

        this.display = new Display();
        this.display.getFrame().addKeyListener(keyManager);
        this.display.getFrame().addMouseListener(mouseManager);
        this.display.getFrame().addMouseMotionListener(mouseManager);

        this.display.getCanvas().addMouseListener(mouseManager);
        this.display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();

        this.handler = new Handler(this);
        this.gameState = new GameState(handler);
        this.menuState = new MenuState(handler);
        this.gameOverState = new GameOverState(handler);

        //change ........
        State.setState(menuState);
    }

    //update the game variables
    private void tick() {

        keyManager.tick();

        if (State.getState() != null)
            State.getState().tick();
    }

    //draw all the game
    private void render() {

        bs = display.getCanvas().getBufferStrategy();

        if (bs == null) {
            display.getCanvas().createBufferStrategy(2);
            return;
        }

        g = bs.getDrawGraphics();
        g.clearRect(0, 0, Launcher.WIDTH, Launcher.HEIGHT);
        //------------> start of drawing

        if (State.getState() != null)
            State.getState().render(g);

        //------------> end of drawing
        bs.show();
        g.dispose();
    }

    //Game Loop
    @Override
    public void run() {

        init();

        int fps = 10;
        double timePerTick = 1e9 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        while (running) {

            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                delta--;
            }
        }

        stop();
    }

    public synchronized void start() {

        if (running) return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {

        if (!running) return;

        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //GETTERS
    public State getGameState() {
        return gameState;
    }

    public State getMenuState() {
        return menuState;
    }

    public State getGameOverState() {
        return gameOverState;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }
}
