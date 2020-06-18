package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Animation.AnimationManager;
import com.mygdx.game.Inventory.Equipment;
import com.mygdx.game.Inventory.Inventory;
import com.mygdx.game.Resources.GameUtils;
import com.mygdx.game.Resources.ResourceManager;

import javax.rmi.CORBA.Util;

/**
 * The protagonist, your character
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class Player extends Entity {

    // Movement
    // -1 stop, 0 down, 1 up, 2 left, 3 right
    public int direction = -1;

    //Battle
    //TODO enemy
    private boolean battling = false;

    // inventory and equipment
    private Inventory inventory;
    private Equipment equipment;

    // check if in game or in menus
    // true = in game, false = in menus
    private boolean inMap = false;

    /**
     * Constructor for the player
     * @param id
     * @param rm
     */
    public Player(String id, ResourceManager rm) {
        super(id, rm);

        inventory = new Inventory();
        equipment = new Equipment();

        level = 1;

        //TODO add animations
        //am = new AnimationManager(rm.sprites, GameUtils.PLAYER_WALKING, GameUtils.PLAYER_WALKING_DELAY);
    }

    /**
     * Updates the player informations
     * @param delta
     */
    public void update(float delta) {
        super.update(delta);

        // Movement
        handleMovement(delta);

        //TODO check interaction
    }

    /**
     * Renders the player
     * @param batch
     */
    public void render(SpriteBatch batch) {
        //batch.draw();
    }

    /**
     * Moves the player
     * Triggered by an input in the GameHud
     * @param dir
     */
    public void move(int dir) {
        direction = dir;
    }

    /**
     * Checks if the player can move
     * Direction == -1 --> true
     * @return
     */
    public boolean canMove() {
        return direction == -1;
    }

    /**
     * Checks if the player is moving
     * Direction != -1 --> true
     * @return
     */
    public boolean isMoving() {
        return direction != -1;
    }

    /**
     * Handles the movements of the player on the map
     * @param delta
     */
    public void handleMovement(float delta) {
        switch (direction) {
            case 0:
                position.y -= delta;
                break;
            case 1:
                position.y += delta;
                break;
            case 2:
                position.x -= delta;
                break;
            case 3:
                position.x += delta;
                break;
        }
    }

    //TODO add item stats calculation

    //TODO add experience handler
}
