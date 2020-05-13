package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.Resources.ResourceManager;
import com.mygdx.game.UI.WorldHud;
import com.mygdx.game.YARG;

import com.mygdx.game.Map.TileMap;

/**
 * Simple tileMap tes
 *
 * @author gfresnais
 */
public class TileMapTest extends AbstractScreen {

    // The tilemap for this screen
    private TileMap map;

    // Onscreen controls
    private WorldHud worldHud;


    public TileMapTest(final YARG game, final ResourceManager rm) {
        super(game, rm);

        // Creating the correct tilemap
        map = new TileMap("test");

        System.out.println(map.getMapProperties());

        // Onscreen controls
        worldHud = new WorldHud(map.getCamera(), game, game.player, rm);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Rendering the world
        map.render();

        // Player
        game.player.render(game.batch);

        // WorldHud rendering
        worldHud.getStage().act(delta);
        worldHud.getStage().draw();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void show() {
        Gdx.input.setInputProcessor(worldHud.getStage());
        game.fps.setPosition(0, Gdx.graphics.getHeight() - 20);
        stage.addActor(game.fps);
    }

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        map.dispose();
        worldHud.dispose();
    }
}
