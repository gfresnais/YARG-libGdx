package com.mygdx.game.UI;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.Resources.ResourceManager;
import com.mygdx.game.YARG;
import com.mygdx.game.Screens.TileMapTest;

/**
 * WorldHud for moving the player
 *
 * @author gfresnais
 */
public class WorldHud extends UI {
    //private Label test;
    private OrthographicCamera camera;

    public WorldHud(OrthographicCamera cam, final YARG game, final Player player, final ResourceManager rm) {
        super(game, player, rm);
        camera = cam;
        FitViewport viewport = new FitViewport(900, 600);
        stage = new Stage(viewport);

        Table table = new Table();
        //table.setDebug(true);
        table.setSize(350, 200);

        // Up button
        TextButton upButton = new TextButton("U", rm.skin);
        upButton.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                translate(0, 1);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        table.add(upButton).width(100).colspan(3).expandX();
        table.row();

        // Left button
        TextButton leftButton = new TextButton("L", rm.skin);
        leftButton.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                translate(-1, 0);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        table.add(leftButton).width(100).expandX();

        // Down button
        TextButton downButton = new TextButton("D", rm.skin);
        downButton.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                translate(0, -1);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        table.add(downButton).width(100).expandX();

        // Right button
        TextButton rightButton = new TextButton("R", rm.skin);
        rightButton.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                translate(1, 0);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        table.add(rightButton).width(100).expandX();

        stage.addActor(table);
    }



    /**
     * Returns the stage attribute
     * @return
     */
    public Stage getStage() {return stage;}

    /**
     * Handles camera translation
     * @param x
     * @param y
     */
    private void translate(float x, float y) {
        camera.translate(x, y);
    }

    @Override
    public void update(float delta) {
        // Update things
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }
}
