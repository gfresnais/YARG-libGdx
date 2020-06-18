package com.mygdx.game.UI;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.Map.TileMap;
import com.mygdx.game.Resources.ResourceManager;
import com.mygdx.game.Screens.GameScreen;
import com.mygdx.game.YARG;


/**
 * Templates for UI screens
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public abstract class UI implements Disposable {

    protected Stage stage;
    protected Viewport viewport;

    protected ResourceManager rm;
    protected Player player;
    protected YARG game;

    // For other UI
    protected TileMap tileMap;
    protected GameScreen screen;

    // Graphics stuff
    protected ShapeRenderer shapeRenderer;

    /**
     * Constructor with common attributes
     *
     * @param game
     * @param player
     * @param rm
     */
    public UI(final YARG game, Player player, ResourceManager rm) {
        this.game = game;
        this.player = player;
        this.rm = rm;

        viewport = new StretchViewport(YARG.V_WIDTH, YARG.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, game.batch);

        shapeRenderer = new ShapeRenderer();
    }

    /**
     * Constructor for other UI (ex: battle)
     *
     * @param screen
     * @param tileMap
     * @param player
     * @param rm
     */
    public UI(GameScreen screen, TileMap tileMap, Player player, ResourceManager rm) {
        this(screen.getGame(), player, rm);
        this.screen = screen;
        this.tileMap = tileMap;
    }

    /**
     * Updates
     *
     * @param delta
     */
    public abstract void update(float delta);

    /**
     * Renders
     *
     * @param delta
     */
    public abstract void render(float delta);

    @Override
    public void dispose() {
        stage.dispose();
        shapeRenderer.dispose();
    }

    /***********/
    /* GETTERS */

    /***********/

    public Stage getStage() {return stage;}
}
