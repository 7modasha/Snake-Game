package com.snakegame.states;

import com.snakegame.Game;
import com.snakegame.Handler;
import com.snakegame.entities.creatures.Snake;
import com.snakegame.entities.items.Food;

import java.awt.*;

/**
 * Created by hmoda on 29-Jul-17.
 */
public class GameState extends State{

    private Food food;
    private Snake snake;

    //for future
    public GameState(Handler handler) {
        super(handler);

        snake = new Snake(handler);
        food = new Food(handler);


        handler.setFood(food);
    }

    //if the user want a new game
    public void reset() {

        snake = new Snake(handler);
        food = new Food(handler);

        handler.setFood(food);
    }

    @Override
    public void tick() {

        if (snake.isDead()) {
            State.setState(handler.getGameOverState());
            return;
        }

        snake.tick();
    }

    @Override
    public void render(Graphics g) {
        food.render(g);
        snake.render(g);

        //score
        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        g.setColor(Color.WHITE);

        //the score is the length of the snake
        g.drawString("Score : " + snake.getLengthOfSnake(), 5, 12);
    }

    public int getScore() {
        return snake.getLengthOfSnake();
    }

}
