package com.snakegame.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by hmoda on 25-Aug-17.
 */
public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }

    public BufferedImage crop(int x, int y, int width, int height){
        return sheet.getSubimage(x, y, width, height);
    }
}
