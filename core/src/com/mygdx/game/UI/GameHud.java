package com.mygdx.game.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.Map.TileMap;
import com.mygdx.game.Resources.GameUtils;
import com.mygdx.game.Resources.ResourceManager;
import com.mygdx.game.Screens.GameScreen;
import com.mygdx.game.YARG;

public class GameHud extends UI {

    // 0 down, 1 up, 2 left, 3 right
    private TextButton[] crossPad;
    // Check if the crossPad is still pressed
    private boolean isPressed;
    // Keeps in memory the current direction
    private int currDir;

    // Related to information at the beginning of the level
    private Window levelInfo;
    private Label levelDesc;
    private boolean isInfoShowing;

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
        crossPad[2].setPosition(GameUtils.CROSS_PAD_OFFSET, GameUtils.CROSS_PAD_SIZE + GameUtils.CROSS_PAD_OFFSET);
        // Right button
        crossPad[3] = new TextButton("R", rm.skin);
        crossPad[3].setPosition(GameUtils.CROSS_PAD_SIZE * 2 + GameUtils.CROSS_PAD_OFFSET, GameUtils.CROSS_PAD_SIZE + GameUtils.CROSS_PAD_OFFSET);

        for (int i = 0; i < crossPad.length; i++) {
            crossPad[i].setSize(YARG.col_width, YARG.row_height);
            crossPad[i].setTransform(true);
            crossPad[i].setScale(0.125f);
        }

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
            final int index = i;
            crossPad[i].addListener(new InputListener() {
                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    isPressed = false;
                }

                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    isPressed = true;
                    currDir = index;
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
        //if (player.canMove()) {
            //TODO add animation
            player.move(dir);
        //}
    }

    /**
     * Creates the level informations window
     */
    private void createLevelInfo() {
        levelInfo = new Window("", rm.skin);
        levelInfo.getTitleLabel().setFontScale(1.0f);
        levelInfo.getTitleLabel().setAlignment(Align.center);
        levelInfo.setMovable(false);
        levelInfo.setTouchable(Touchable.disabled);
        levelInfo.setKeepWithinStage(false);
        levelInfo.setVisible(false);

        levelDesc = new Label("", new Label.LabelStyle(rm.font, Color.WHITE));
        levelDesc.setFontScale(1.0f);
        levelDesc.setAlignment(Align.center);

        levelInfo.left();
        levelInfo.pad(12, 2, 4, 0);
        levelInfo.add(levelDesc).width(100);

        stage.addActor(levelInfo);

        // TODO check for moving windows
    }

    /**
     * Shows the informations of the Level
     */
    public void startLevelInfo() {
        levelInfo.getTitleLabel().setText("HELLO WORLD!");
        levelDesc.setText("This is a test level");
        levelInfo.setVisible(true);
        levelInfo.pack();

        //TODO check params for moving windows

        isInfoShowing = true;
    }

    /**
     * Sets the visibility of the HUD
     * @param visibility
     */
    public void setVisibility(boolean visibility) {
        for (int i = 0; i < crossPad.length; i++) {
            crossPad[i].setVisible(visibility);
        }
        levelInfo.setVisible(visibility);
    }

    @Override
    public void update(float delta) {
        if(isPressed) {
            movePlayer(currDir);
        } //else {
            // stop player animation
        //}

        // Visible Level Information Window
        // TODO check for moving windows
        //if(isInfoShowing) {
            //levelInfo.setPosition(0,0);
        //}
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }
}
