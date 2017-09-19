package com.snakegame.ui;

import com.snakegame.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by hmoda on 25-Aug-17.
 */
public class UIManager {

    private Handler handler;
    private ArrayList<UIObject> objects;

    public UIManager(Handler handler){
        this.handler = handler;
        objects = new ArrayList<UIObject>();
    }

    public void tick(){
        for(UIObject o : objects)
            o.tick();
    }

    public void render(Graphics g){
        for(UIObject o : objects)
            o.render(g);
    }

    public void onMouseMove(MouseEvent e){
        for(UIObject o : objects)
            o.onMouseMove(e);
    }

    public void onMouseRelease(MouseEvent e){
        for(UIObject o : objects)
            o.onMouseRelease(e);
    }

    public void addObject(UIObject o){
        objects.add(o);
    }

    public void removeObject(UIObject o){
        objects.remove(o);
    }


    //GETTERS AND SETTERS
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<UIObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }

}
