package com.mygdx.game.Inventory;

/**
 * Inventory
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class Inventory {

    // Number of inventory slots
    private final int NUM_SLOTS = 10;

    private Item[] items;

    public Inventory() {
        items = new Item[NUM_SLOTS];
    }

    /**
     * Check if the slot at the given index is empty
     * @param index
     * @return
     */
    public boolean isFreeSlot(int index) {
        return items[index] == null;
    }

    /**
     * Returns the index of the first free slot
     * -1 if it's full
     * @return
     */
    public int getFirstFreeSlotIndex() {
        for (int i = 0; i < NUM_SLOTS; i++) {
            if(isFreeSlot(i)) return i;
        }
        return -1;
    }

    /**
     * Adds an item to the inventory
     * If it's full, returns false
     * @param item
     * @return
     */
    public boolean addItem(Item item) {
        int i = getFirstFreeSlotIndex();
        if( i != -1 ) {
            items[i] = item;
            return true;
        }
        return false;
    }

    /**
     * Removes the items in the given index
     * @param index
     */
    public void removeItem(int index) {
        if(items[index] != null) items[index] = null;
    }

    /**
     * Checks if the inventory is full
     * @return
     */
    public boolean isFull() {
        for (int i = 0; i < NUM_SLOTS; i++) {
            if(items[i] == null) return false;
        }
        return true;
    }

    /**
     * Empties the inventory
     */
    public void clear() {
        for (int i = 0; i < NUM_SLOTS; i++) {
            removeItem(i);
        }
    }
}
