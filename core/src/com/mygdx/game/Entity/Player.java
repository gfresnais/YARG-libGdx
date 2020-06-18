package com.mygdx.game.Entity;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Entity.Animation.AnimationPlayer;
import com.mygdx.game.Inventory.Equipment;
import com.mygdx.game.Inventory.Inventory;
import com.mygdx.game.Resources.ResourceManager;

/**
 * The protagonist, your character
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class Player extends Entity {

    // Animation
    private AnimationPlayer am;

    // Movement
    // -1 stop, 0 down, 1 up, 2 left, 3 right
    public int direction = -1;

    //Battle
    private Enemy opponent;
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

        // World animation
        am = new AnimationPlayer(this, rm);
    }

    /**
     * Updates the player informations
     * @param delta
     */
    public void update(float delta) {
        super.update(delta);

        // Movement
        handleMovement(delta);

        // Animation
        am.update(delta);

        //TODO check interaction
    }

    /**
     * Renders the player using a batch
     * @param batch
     */
    public void render(SpriteBatch batch) {
        batch.draw(am.getAm(), position.x, position.y);
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
            case 0: // Down
                position.y -= delta;
                am.setAnimIndex(0);
                break;
            case 1: // Up
                position.y += delta;
                am.setAnimIndex(3);
                break;
            case 2: // Left
                position.x -= delta;
                am.setAnimIndex(1);
                break;
            case 3: // Right
                position.x += delta;
                am.setAnimIndex(2);
                break;
        }
    }

    //TODO add item stats calculation

    //TODO add experience handler

    public TextureRegion getAnim() { return am.getAm(); }
}
