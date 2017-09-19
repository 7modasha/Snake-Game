package com.snakegame.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by hmoda on 25-Aug-17.
 */
public class Assets {

    public static BufferedImage background;
    public static BufferedImage[] startBtn, aboutBtn, backBtn;

    public static void  init() {

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/MenuSpriteSheet.png"));

        background = ImageLoader.loadImage("/res/MenuBackground.jpg");

        startBtn = new BufferedImage[2];
        startBtn[0] = sheet.crop(0, 0, 183, 74);
        startBtn[1] = sheet.crop(183, 0, 183, 74);

        aboutBtn = new BufferedImage[2];
        aboutBtn[0] = sheet.crop(0, 74, 90, 35);
        aboutBtn[1] = sheet.crop(90, 74, 90, 35);

    }

}
