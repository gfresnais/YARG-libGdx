package com.mygdx.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    }

    /**
     * Updates the player informations
     * @param delta
     */
    public void update(float delta) {
        super.update(delta);

        //TODO add movement handling

        //TODO check interaction
    }

    /**
     * Renders the player
     * @param batch
     */
    public void render(SpriteBatch batch) {
        //TODO set the correct sprite
    }

    //TODO add movements methods

    //TODO add item stats calculation

    //TODO add experience handler
}
