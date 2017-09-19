package com.snakegame.ui;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by hmoda on 25-Aug-17.
 */
public class SButton extends UIObject{

    private BufferedImage[] images;
    private ClickListener clicker;

    public SButton(int x, int y, int width, int height,
                   BufferedImage[] images, ClickListener clicker) {

        super(x, y, width, height);

        this.images = images;
        this.clicker = clicker;
    }

    @Override
    public void tick() {}

    @Override
    public void render(Graphics g) {

        if (hovering)
            g.drawImage(images[1], x, y, width, height, null);
        else
            g.drawImage(images[0], x, y, width, height, null);

    }

    @Override
    public void onClick() {
        clicker.onClick();
    }
}
