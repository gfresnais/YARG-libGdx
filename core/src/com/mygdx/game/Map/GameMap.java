package com.mygdx.game.Map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.Resources.ResourceManager;
import com.mygdx.game.Screens.GameScreen;

/**
 * Handles the game map
 * Is responsible for player movements
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class GameMap {
    private TileMap tileMap;

    private Player player;
    private ResourceManager rm;
    private GameScreen screen;

    /**
     * Constructor
     * @param player
     * @param rm
     */
    public GameMap(GameScreen screen, Player player, ResourceManager rm, String mapName) {
        this.screen = screen;
        this.player = player;
        this.rm = rm;

        tileMap = new TileMap(mapName);
    }


    /**
     * Updating player informations and tilemap entities
     * @param delta
     */
    public void update(float delta) {
        player.update(delta);
        tileMap.update(delta);

        //TODO add game states for the player interactions
    }

    /**
     * Rendering the tilemap and the player
     * @param delta
     * @param batch
     * @param cam
     */
    public void render(float delta, SpriteBatch batch, OrthographicCamera cam) {
        tileMap.render(batch, cam);
        player.render(batch);
    }


    /***********/
    /* GETTERS */
    /***********/

    public TileMap getTileMap() {
        return tileMap;
    }

    public Player getPlayer() {
        return player;
    }

    public ResourceManager getRm() {
        return rm;
    }

    public GameScreen getScreen() {
        return screen;
    }

}
