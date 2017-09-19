package com.snakegame.states;

import com.snakegame.Handler;
import com.snakegame.Launcher;
import com.snakegame.display.Display;

import java.awt.*;


public class GameOverState extends State{

    private Rectangle bigRect;
    private Rectangle newGameButton;

    private StringToDraw gameOver, yourScore, newGame;

    public GameOverState(Handler handler) {
        super(handler);

        int x, y;

        x = Launcher.WIDTH / 2 - 400 / 2;
        y = Launcher.HEIGHT / 2 - 300 / 2;
        bigRect = new Rectangle(x, y, 400, 300);

        x = Launcher.WIDTH / 2 - 150 / 2;
        y = Launcher.HEIGHT / 2 - 50 / 2 + 70;
        newGameButton = new Rectangle(x, y, 150, 50);

        gameOver = new StringToDraw("Game Over", new Font(Font.SANS_SERIF, Font.BOLD, 55), 292);
        newGame = new StringToDraw("New Game", new Font(Font.MONOSPACED, Font.BOLD, 20), 96);
    }

    //true if the mouse hover over the new game button
    private boolean isHovering() {
        return newGameButton.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY());
    }


    @Override
    public void tick() {

        //for the button
        if (isHovering() && handler.getMouseManager().isLeftPressed()) {
            handler.getGameState().reset();
            yourScore = null;
            State.setState(handler.getGameState());
        }
    }

    @Override
    public void render(Graphics g) {

        //draw the rectangles
        g.setColor(Color.WHITE);
        g.drawRect(bigRect.x, bigRect.y, bigRect.width, bigRect.height);

        //Game Over
        g.setFont(gameOver.font);
        g.drawString(gameOver.str, Launcher.WIDTH / 2 - gameOver.width / 2, Launcher.HEIGHT / 2 - 75); //75 is the y offset

        //calculating the score and append it the yourScore string
        //I put it here because i need the Graphics object to calc the width of the string
        //after i append the score
        if (yourScore == null) {
            yourScore = new StringToDraw("Your score is : " + Integer.toString(handler.getGameState().getScore()) ,
                    new Font(Font.MONOSPACED, Font.PLAIN, 15), 0);

            yourScore.width = g.getFontMetrics(yourScore.font).stringWidth(yourScore.str);
        }

        //Your score is :
        g.setFont(yourScore.font);
        g.drawString(yourScore.str, Launcher.WIDTH / 2 - yourScore.width / 2, Launcher.HEIGHT / 2 - 30); //10 is the y offset

        //new game
        g.setFont(newGame.font);

        if (isHovering()) {

            g.setColor(Color.WHITE);
            g.fillRect(newGameButton.x, newGameButton.y, newGameButton.width, newGameButton.height);
            g.setColor(Display.BACK_COLOR);
            g.drawString(newGame.str, Launcher.WIDTH / 2 - newGame.width / 2, Launcher.HEIGHT / 2 + 75); //75 is the y offset

        } else {

            g.setColor(Color.WHITE);
            g.drawString(newGame.str, Launcher.WIDTH / 2 - newGame.width / 2, Launcher.HEIGHT / 2 + 75); //75 is the y offset
            g.drawRect(newGameButton.x, newGameButton.y, newGameButton.width, newGameButton.height);
        }
    }

    private class StringToDraw {

        String str;
        Font font;
        int width;

        StringToDraw(String str, Font font, int width) {
            this.str = str;
            this.font = font;
            this.width = width;
        }
    }
}
