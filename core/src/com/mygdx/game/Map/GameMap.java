package com.mygdx.game.Map;

import com.badlogic.gdx.audio.Music;
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

    //TODO Handle music
    private Music mapTheme;

    /**
     * Constructor
     * @param player
     * @param rm
     */
    public GameMap(GameScreen screen, Player player, ResourceManager rm) {
        this.screen = screen;
        this.player = player;
        this.rm = rm;
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

    public Music getMapTheme() {
        return mapTheme;
    }

}
