package com.mygdx.game.Entity;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Map.TileMap;
import com.mygdx.game.Resources.ResourceManager;

/**
 * Defines what an Enemy is
 * Enemy is a special Entity
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class Enemy extends Entity{

    /**
     * Constructor for Enemy
     * @param id
     * @param rm
     * @param position
     * @param tileMap
     */
    public Enemy(String id, ResourceManager rm, Vector2 position, TileMap tileMap) {
        super(id, rm, position, tileMap);
    }

    //TODO add special status for bosses
}
