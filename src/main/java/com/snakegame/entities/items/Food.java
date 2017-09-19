package com.snakegame.entities.items;

import com.snakegame.Handler;
import com.snakegame.Launcher;
import com.snakegame.entities.Entity;

import java.awt.*;

/**
 * Created by hmoda on 30-Jul-17.
 */
public class Food extends Entity {

    private Rectangle bounds;

    private static final int SIDE = 13;

    public Food(Handler handler) {
        super(handler, 0, 0, SIDE);
        tick();
    }

    @Override
    public void tick() {
        x = (int)(Math.random() * ((Launcher.WIDTH - SIDE) / side) + 1) * side;
        y = (int)(Math.random() * ((Launcher.HEIGHT - SIDE) / side) + 1) * side;

        this.bounds = new Rectangle(x, y, side, side);

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x ,y, side, side);
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
