package com.mygdx.game.Event;

import com.mygdx.game.Entity.Enemy;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.Map.TileMap;
import com.mygdx.game.Screens.GameScreen;

/**
 * Handles the Battle event
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class Battle {
    private Enemy opponent;

    private GameScreen screen;
    private TileMap tileMap;
    private Player player;

    /**
     * Battle constructor
     * @param screen
     * @param tileMap
     * @param player
     */
    public Battle(GameScreen screen, TileMap tileMap, Player player) {
        this.screen = screen;
        this.tileMap = tileMap;
        this.player = player;
    }

    /**
     * Sets the opponent stats
     * @param opponent
     */
    public void begin(Enemy opponent) {
        this.opponent = opponent;
    }

    /**
     * Ends the battle
     */
    public void end() {
        opponent = null;
    }
}
