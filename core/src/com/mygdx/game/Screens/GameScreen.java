package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.Background.Background;
import com.mygdx.game.Map.GameMap;
import com.mygdx.game.Resources.ResourceManager;
import com.mygdx.game.Event.Battle;
import com.mygdx.game.YARG;

/**
 * Handles all gameplay
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class GameScreen extends AbstractScreen {

    // World variables
    private GameMap gameMap;
    private Battle battle;

    // Background
    private Background[] backgrounds;

    public GameScreen(final YARG game, final ResourceManager rm) {
        super(game, rm);

        gameMap = new GameMap(this, game.player, rm);
        battle = new Battle(this, gameMap.getTileMap(), gameMap.getPlayer());

        // Creation of backgrounds
        backgrounds = new Background[2];
        // sky layer
        //backgrounds[0] = new Background();
        // field layer
        //backgrounds[1] = new Background();
    }

    public void update(float delta) {

    }

    public void render(float delta) {
        update(delta);

        // Clears screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


    }

    public void dispose() {
        super.dispose();
    }
}
