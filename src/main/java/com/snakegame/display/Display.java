package com.snakegame.display;

import com.snakegame.Launcher;

import javax.swing.*;
import java.awt.*;

/**
 * Created by hmoda on 28-Jul-17.
 */
public class Display {

    public static final Color BACK_COLOR = Color.DARK_GRAY;

    private JFrame frame;
    private Canvas canvas;

    public Display() {

        createDisplay();
    }

    private void createDisplay() {

        //constructing the frame
        frame = new JFrame(Launcher.TITLE);
        frame.setSize(Launcher.WIDTH, Launcher.HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //constructing the drawing area
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(Launcher.WIDTH, Launcher.HEIGHT));
        canvas.setMaximumSize(new Dimension(Launcher.WIDTH, Launcher.HEIGHT));
        canvas.setMinimumSize(new Dimension(Launcher.WIDTH, Launcher.HEIGHT));
        canvas.setFocusable(false);
        canvas.setBackground(BACK_COLOR);

        frame.add(canvas);
        frame.pack(); // To resize the frame so it can display the canvas fully
    }

    public JFrame getFrame() {
        return frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
