package com.mygdx.game.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Resources.ResourceManager;
import com.mygdx.game.YARG;

/**
 * Screen template for game screens and states
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public abstract class AbstractScreen implements Screen {

    protected final YARG game;
    protected final ResourceManager rm;

    // Main stage of each screen
    protected final Stage stage;

    // Camera that focuses on the player
    protected OrthographicCamera cam;

    // Viewport of the screen to keep aspect ratio if needed
    protected Viewport viewport;

    public AbstractScreen(final YARG game, final ResourceManager rm) {
        this.game = game;
        this.rm = rm;

        // Needs width and height of the game
        cam = new OrthographicCamera(YARG.V_WIDTH, YARG.V_HEIGHT);
        cam.setToOrtho(false);

        // Keeps the aspect ratios for screen dimensions
        viewport = new StretchViewport(YARG.V_WIDTH, YARG.V_HEIGHT, cam);

        // Sets the viewport and the SpriteBatch
        stage = new Stage(viewport, game.batch);
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
    }

    /***********/
    /* GETTERS */
    /***********/

    public YARG getGame() { return game; }

    //TODO add screen transition method
}
