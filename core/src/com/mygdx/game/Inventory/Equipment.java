package com.mygdx.game.Inventory;

import com.badlogic.gdx.math.Vector2;

/**
 * Manages the equipment the player can use and equip
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class Equipment {
    /*
    TODO define what can be equipped
     */
    public static final int NUM_SLOTS = 1;

    private Item[] equips;
    // stores the positions of equip slots
    private Vector2[] positions;

    /**
     * Constructor for the equipment
     */
    public Equipment() {
        equips = new Item[NUM_SLOTS];
        positions = new Vector2[NUM_SLOTS];

        //TODO set all positions according to NUM_SLOTS
        positions[0] = new Vector2(50, 50);
    }

    /**
     * Adds an equipment item to the correct equip slot
     * @param equip
     * @return
     */
    public boolean addEquip(Item equip) {
        // Check the availability of the slot
        if( equips[equip.getType()] == null ) {
            equips[equip.getType()] = equip;
            equip.setEquipped(true);
            return true;
        }
        return false;
    }

    /**
     * Removes an equip at a given index and returns the corresponding Item
     * @param index
     * @return
     */
    public Item removeEquip(int index) {
        // If there is an equipped Item
        if( equips[index] != null ) {
            Item result = equips[index];
            equips[index] = null;
            return result;
        }
        return null;
    }
}
