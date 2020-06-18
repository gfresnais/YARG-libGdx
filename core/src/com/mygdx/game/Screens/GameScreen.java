package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.Background.Background;
import com.mygdx.game.Map.GameMap;
import com.mygdx.game.Map.TileMap;
import com.mygdx.game.Resources.ResourceManager;
import com.mygdx.game.Event.Battle;
import com.mygdx.game.UI.GameHud;
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

    // HUD
    private GameHud gameHud;

    // Input
    private InputMultiplexer multiplexer;

    public GameScreen(final YARG game, final ResourceManager rm) {
        super(game, rm);

        // Creating screen elements
        gameMap = new GameMap(this, game.player, game.rm, "test"); // mapName is just a test for the moment
        gameHud = new GameHud(this, gameMap.getTileMap(), game.player, game.rm);

        //battle = new Battle(this, gameMap.getTileMap(), gameMap.getPlayer());

        // Creation of backgrounds
        //backgrounds = new Background[2];
        // sky layer
        //backgrounds[0] = new Background();
        // field layer
        //backgrounds[1] = new Background();

        // Input multiplexer
        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(gameHud.getStage());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(multiplexer);
    }


    /**
     * Updates the camera
     * It follows the player
     */
    public void updateCamera() {

        if( gameMap.getPlayer().getPosition().x <= gameMap.getTileMap().getMapWidth() ) {
            cam.position.x = gameMap.getPlayer().getPosition().x + 64;
        }

        if( gameMap.getPlayer().getPosition().y <= gameMap.getTileMap().getMapHeight() ) {
            cam.position.y = gameMap.getPlayer().getPosition().y + 64;
        }
    }

    /**
     * Updates informations of the game screen
     * @param delta
     */
    public void update(float delta) {
        //TODO check the states

        // Update camera
        updateCamera();

        // Update map
        gameMap.update(delta);

        // Update hud
        gameHud.update(delta);
    }

    /**
     * Renders the game screen
     * @param delta
     */
    public void render(float delta) {
        update(delta);

        // Clears screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        // Renders the tilemap
        gameMap.render(delta, game.batch, cam);

        // Renders the player
        game.batch.draw(game.player.getAnim(), game.player.getPosition().x, game.player.getPosition().y);

        game.batch.end();

        gameHud.render(delta);

        //game.logProfile("GameScreen");
    }

    public void dispose() {
        super.dispose();

        gameHud.dispose();
    }
}
