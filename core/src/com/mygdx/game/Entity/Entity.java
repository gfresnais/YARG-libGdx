package com.mygdx.game.Entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Map.TileMap;
import com.mygdx.game.Resources.ResourceManager;

/**
 * Define what an Entity is, what animations to do and where to place it on the map
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class Entity {
    protected String id;
    protected ResourceManager rm;

    //TODO add animation handling

    //TODO add battle scene

    // The coordinates of the entity on the map (x, y)
    protected Vector2 position;

    // map
    protected TileMap tileMap;


    /************ RPG ************/
    protected boolean dead = false;

    protected int hp;
    protected int maxHp;

    protected int level;

    /**
     * Basic constructor for creating an Entity
     * @param id
     * @param rm
     */
    public Entity(String id, ResourceManager rm) {
        this.id = id;
        this.rm = rm;

        // position to be set afterwards
        position = new Vector2();
    }

    /**
     * Full constructor with position and map set
     * @param id
     * @param rm
     * @param position
     * @param tileMap
     */
    public Entity(String id, ResourceManager rm, Vector2 position, TileMap tileMap) {
        this(id, rm);
        this.position = position;
        this.tileMap = tileMap;
    }

    /**
     * Updates the Entity information
     * @param delta
     */
    public void update(float delta) {
        // rpg
        if(hp > maxHp) hp = maxHp;
        if( hp <= 0 ) hp = 0;

        //TODO add animation handler
    }

    /**
     * Renders the Entity
     * @param batch
     * @param looping
     */
    public void render(SpriteBatch batch, boolean looping) {
        //TODO add animation of the sprite
    }

    /**
     * When hit, hp decrease
     * @param damage
     */
    public void hit(int damage) {
        hp -= damage;
        if(hp <= 0) {
            hp = 0;
            dead = true;
        }
    }

    /**
     * When healed, hp increase
     * @param heal
     */
    public void heal(int heal) {
        hp += heal;
        if( hp > maxHp ) hp = maxHp;
    }

    //TODO add related map methods
}
