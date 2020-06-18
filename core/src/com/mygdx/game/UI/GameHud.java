package com.mygdx.game.UI;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.Map.TileMap;
import com.mygdx.game.Resources.GameUtils;
import com.mygdx.game.Resources.ResourceManager;
import com.mygdx.game.Screens.GameScreen;

public class GameHud extends UI {

    // 0 down, 1 up, 2 left, 3 right
    private TextButton[] crossPad;
    // Check if the crossPad is still pressed
    private boolean isPressed;

    // Related to information at the beginning of the level
    private Window levelInfo;
    private Label levelDesc;

    /**
     * Constructor
     * @param screen
     * @param tileMap
     * @param player
     * @param rm
     */
    public GameHud(final GameScreen screen, TileMap tileMap, final Player player, final ResourceManager rm) {
        super(screen, tileMap, player, rm);

        createCrossPad();
        createLevelInfo();
    }

    /**
     * Creates the buttons for the crossPad
     * Have to do this manually because of the position
     */
    private void createCrossPad() {
        crossPad = new TextButton[4];

        // Down button
        crossPad[0] = new TextButton("D", rm.skin);
        crossPad[0].setPosition(GameUtils.CROSS_PAD_SIZE + GameUtils.CROSS_PAD_OFFSET, GameUtils.CROSS_PAD_OFFSET);
        // Up button
        crossPad[1] = new TextButton("U", rm.skin);
        crossPad[1].setPosition(GameUtils.CROSS_PAD_SIZE + GameUtils.CROSS_PAD_OFFSET, GameUtils.CROSS_PAD_SIZE * 2 + GameUtils.CROSS_PAD_OFFSET);
        // Left button
        crossPad[2] = new TextButton("L", rm.skin);
        crossPad[2].setPosition(GameUtils.CROSS_PAD_SIZE * 2 + GameUtils.CROSS_PAD_OFFSET, GameUtils.CROSS_PAD_SIZE + GameUtils.CROSS_PAD_OFFSET);
        // Right button
        crossPad[3] = new TextButton("R", rm.skin);
        crossPad[3].setPosition(GameUtils.CROSS_PAD_OFFSET, GameUtils.CROSS_PAD_SIZE + GameUtils.CROSS_PAD_OFFSET);

        handleCrossPadEvents();

        for (int i = 0; i < crossPad.length; i++) {
            stage.addActor(crossPad[i]);
        }
    }

    /**
     * Handles whenever a button of the crossPad is pressed
     */
    private void handleCrossPadEvents() {
        for (int i = 0; i < crossPad.length; i++) {
            crossPad[i].addListener(new InputListener() {
                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    isPressed = false;
                }

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    isPressed = true;
                    return true;
                }
            });
        }
    }

    /**
     * Makes the player move according to a given direction
     * @param dir
     */
    private void movePlayer(int dir) {
        // Add player movement
    }

    /**
     * Creates the level informations window
     */
    private void createLevelInfo() {
        levelInfo = new Window("", rm.skin);
        //TODO add the rest
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta) {

    }
}
