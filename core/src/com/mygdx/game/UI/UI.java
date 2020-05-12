package com.mygdx.game.UI;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.Resources.ResourceManager;
import com.mygdx.game.YARG;


/**
 * Templates for UI screens
 *
 * @author gfresnais
 */
public abstract class UI implements Disposable {

    protected Stage stage;
    protected Viewport viewport;

    protected ResourceManager rm;
    protected Player player;
    protected YARG game;

    // Graphics stuff
    protected ShapeRenderer shapeRenderer;

    /**
     * Constructor
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
     * Updates
     * @param dt
     */
    public abstract void update(float dt);

    /**
     * Renders
     * @param dt
     */
    public abstract void render(float dt);

    @Override
    public void dispose() {
        stage.dispose();
        shapeRenderer.dispose();
    }
}
