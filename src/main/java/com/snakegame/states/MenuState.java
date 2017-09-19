package com.snakegame.states;

import com.snakegame.Handler;
import com.snakegame.Launcher;
import com.snakegame.gfx.Assets;
import com.snakegame.ui.SButton;
import com.snakegame.ui.UIManager;

import javax.swing.*;
import java.awt.*;

public class MenuState extends State{

    //to handle all the ui buttons and display them
    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);

        uiManager = new UIManager(handler);

        handler.getMouseManager().setUiManager(uiManager);

        //Start Button
        uiManager.addObject(new SButton(Launcher.WIDTH / 2 - 92, Launcher.HEIGHT / 2 - 36 + 40, 183, 74, Assets.startBtn,

                () -> State.setState(handler.getGameState())));

        uiManager.addObject(new SButton(Launcher.WIDTH - 90 - 10, Launcher.HEIGHT - 35 - 10, 90, 35, Assets.aboutBtn,
                () -> JOptionPane.showMessageDialog(null, "Thank you for playing my game\nEnjoy...", "About", JOptionPane.INFORMATION_MESSAGE)));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background, 0, 0, null);
        uiManager.render(g);
    }
}
