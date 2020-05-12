package com.mygdx.game.Controllers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class InputController {
    Viewport viewport;
    Stage stage;
    boolean upPressed, downPressed, leftPressed, rightPressed;
    OrthographicCamera camera;

    public InputController() {
        camera = new OrthographicCamera();
        stage = new Stage();

        /*stage.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, int button) {
                return true;
            }

            @Override
            public boolean touchUp(InputEvent event, int button) {
                return true;
            }
        });*/
    }

    public boolean isUpPressed() { return upPressed; }
    public boolean isDownPressed() { return downPressed; }
    public boolean isLeftPressed() { return leftPressed; }
    public boolean isRightPressed() { return rightPressed; }
}
