package com.snakegame.entities.creatures;

import com.snakegame.Handler;
import com.snakegame.Launcher;
import com.snakegame.display.Display;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by hmoda on 29-Jul-17.
 */
public class Snake extends Creature {

    private Rectangle headBounds;

    //the body follow the head
    private ArrayList<Rectangle> body;

    private boolean dead;

    private int lengthOfSnake;

    public Snake(Handler handler) {
        super(handler, 0, 0, Creature.DEF_SIDE);

        //finding random pos for the snake to start with
        x = (int)(Math.random() * ((Launcher.WIDTH - Creature.DEF_SIDE) / side) + 1) * side;
        y = (int)(Math.random() * ((Launcher.HEIGHT - Creature.DEF_SIDE) / side) + 1) * side;

        //initialize all variables
        this.body = new ArrayList<>();
        this.dead = false;
        this.lengthOfSnake = 0;
        this.headBounds = new Rectangle(x, y, side, side);
    }

    //get user input and change direction
    private void getInput() {

        boolean up = handler.getKeyManager().up,
                down = handler.getKeyManager().down,
                left = handler.getKeyManager().left,
                right = handler.getKeyManager().right;


        if (up && yMove == 0 && !left && !right && !down) {
            yMove = -1; xMove = 0;
        }
        else if (down && yMove == 0 && !up && !left && !right) {
            yMove = 1; xMove = 0;
        }
        else if (right && xMove == 0 && !left && !up && !down) {
            xMove = 1; yMove = 0;
        }
        else if (left && xMove == 0 && !up && !down && !right) {
            xMove = -1; yMove = 0;
        }
    }

    private void moveSnake() {

        //shift the body(moving the body)

        if (!collisionWithFood()) {

            for (int i = 0; i < body.size() - 1; ++i) {
                body.set(i, body.get(i + 1));
            }
            if (body.size() != 0)
                body.set(body.size() - 1, new Rectangle(x, y, side, side));

        } else {
            body.add(new Rectangle(x, y, side, side));
            handler.getFood().tick();
            lengthOfSnake += Creature.DEF_SIDE;
        }

        move(); //move the head

        this.headBounds = new Rectangle(x, y, side, side);
    }

    //the snake eat it self or not
    private boolean SelfCollision() {

        for (int i = 0;  i < body.size(); ++i) {
            if (headBounds.intersects(body.get(i)))
                return true;
        }
        return false;
    }

    //the snake eat the food
    private boolean collisionWithFood() {

        //if the head and the food intersects
        return headBounds.intersects(handler.getFood().getBounds());
    }


    @Override
    public void tick() {

        if (!this.dead) {

            getInput();
            moveSnake();

            if (SelfCollision()) this.dead = true;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, side, side);
        g.setColor(Display.BACK_COLOR);
        g.drawRect(x, y, side, side);

        for (Rectangle r : body) {
            g.setColor(Color.WHITE);
            g.fillRect(r.x, r.y, side, side);
            g.setColor(Display.BACK_COLOR);
            g.drawRect(r.x, r.y, side, side);
        }
    }

    public boolean isDead() {
        return this.dead;
    }

    public int getLengthOfSnake() {
        return lengthOfSnake;
    }
}
