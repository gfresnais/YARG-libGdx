package com.mygdx.game.Resources;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Entity.Enemy;
import com.mygdx.game.Entity.Entity;
import com.mygdx.game.Map.TileMap;

/**
 * Set of useful variables and functions
 *
 * @author gfresnais
 */
public class GameUtils {

    // Animation indexes
    public static final int PLAYER_WALKING = 0;

    // Animation delay
    public static final float PLAYER_WALKING_DELAY = 1 / 6f;

    /**
     * Returns an Entity according to the given id
     * Helps for enemy generation
     *
     * @param id
     * @param position
     * @param map
     * @param rm
     * @return
     */
    public static Entity getEntity(int id, Vector2 position, TileMap map, ResourceManager rm) {
        switch (id) {
            case 2: return new Enemy("monster", rm, position, map);
        }
        return null;
    }
}
