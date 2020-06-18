package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Resources.ResourceManager;
import com.mygdx.game.YARG;

public class OptionsScreen extends AbstractScreen {
    private Stage stage;

    public OptionsScreen(final YARG game, final ResourceManager rm) {
        super(game, rm);

        // Create the stage (2D scene)
        stage = new Stage(new ScreenViewport());

        // Title (label)
        Label title = new Label("Options Screen", rm.skin, "black");
        title.setFontScale(3);
        title.setSize(w, YARG.row_height * 2);
        title.setPosition(0, h - YARG.row_height * 2);
        title.setAlignment(Align.center);
        stage.addActor(title);

        // Text Button
        Button t_button = new TextButton("Back", rm.skin);
        t_button.setSize(YARG.col_width * 4, YARG.row_height);
        t_button.setPosition(w / 2 - t_button.getWidth() / 2, h / 2 - t_button.getHeight() / 2);
        t_button.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.changeScreen(ScreenState.TITLE_SCREEN);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(t_button);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        // Create a white background
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Initialize the stage
        stage.act();
        // Draw the stage
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
}
