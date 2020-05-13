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

public class TitleScreen extends AbstractScreen {
    private Stage stage;
    private Label state_label;

    float w, h;

    /**
     * Constructor for TitleScreen
     * @param game
     * @param rm
     */
    public TitleScreen(final YARG game, final ResourceManager rm) {
        super(game, rm);

        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();

        // Create the stage (2D scene)
        stage = new Stage(new ScreenViewport());

        // Title (label)
        Label title = new Label("Main Menu", rm.skin, "black");
        title.setFontScale(3);
        title.setSize(Gdx.graphics.getWidth(), YARG.row_height * 2);
        title.setPosition(0, h - YARG.row_height * 2);
        title.setAlignment(Align.center);
        stage.addActor(title);


        // Text Button
        Button t_button = new TextButton("Test", rm.skin);
        t_button.setSize(YARG.col_width * 4, YARG.row_height);
        t_button.setPosition(w / 2f - t_button.getWidth() / 2, h / 2f - YARG.row_height);
        t_button.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                state_label.setText("Press a button");
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                state_label.setText("t_button pressed");
                return true;
            }
        });
        stage.addActor(t_button);

        // Text Button
        Button play_button = new TextButton("Play", rm.skin);
        play_button.setSize(YARG.col_width * 4, YARG.row_height);
        play_button.setPosition(w / 2f - play_button.getWidth() / 2, h / 2f);
        play_button.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.changeScreen(ScreenState.PLAY_SCREEN);
                dispose();
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(play_button);

        // Text Button (Options)
        Button options_button = new TextButton("Options", rm.skin);
        options_button.setSize(YARG.col_width * 4, YARG.row_height);
        options_button.setPosition(w / 2f - options_button.getWidth() / 2, h / 2f + YARG.row_height);
        options_button.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.changeScreen(ScreenState.OPTIONS_SCREEN);
                //dispose();
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(options_button);

        // State label
        state_label = new Label("Press a button", rm.skin, "black");
        state_label.setFontScale(3);
        state_label.setSize(Gdx.graphics.getWidth(), YARG.row_height);
        state_label.setPosition(0, YARG.row_height);
        state_label.setAlignment(Align.center);
        stage.addActor(state_label);

        // Menu music
        rm.playMusic(1, true);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        game.fps.setPosition(0, h - 20);
        stage.addActor(game.fps);

        rm.playMusic(1, true);
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
}
