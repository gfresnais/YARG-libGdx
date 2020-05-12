package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {
    private Texture texture;
    private float x, y;

    public Player() {
        super();
        texture = new Texture(Gdx.files.internal("badlogic.jpg"));
    }

    public Player(float _x, float _y) {
        this();
        x = _x;
        y = _y;
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(texture, x, y);
    }

    @Override
    public void act(float delta) {

    }
}
