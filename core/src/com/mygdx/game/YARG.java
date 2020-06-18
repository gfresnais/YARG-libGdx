package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.profiling.GLProfiler;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.Background.Background;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.Resources.ResourceManager;
import com.mygdx.game.Save.Save;
import com.mygdx.game.Screens.GameScreen;
import com.mygdx.game.Screens.OptionsScreen;
import com.mygdx.game.Screens.ScreenState;
import com.mygdx.game.Screens.TitleScreen;

/**
 * YARG is a RPG game developped with libGDX
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 * for some of the codebase
 */
public class YARG extends Game {

	// General information of the game
	public static final String VERSION = "1.0";
	public static final String TITLE = "YARG Version " + VERSION;

	// Links
	public static final String GITHUB = "https://github.com/gfresnais/";

	// Desktop screen dimensions
	public static final int V_WIDTH = 200;
	public static final int V_HEIGHT = 120;
	public static final int V_SCALE = 6;

	// Rendering utilities
	public SpriteBatch batch;

	// Resources
	public ResourceManager rm;

	// Universal player
	public Player player;

	// Save system
	public Save save;

	// Screens
	private OptionsScreen optionsScreen;
	private TitleScreen titleScreen;
	private GameScreen playScreen;
	//TODO

	// Background
	Background[] menuBackground;

	// For debugging purposes
	public Label fps;
	public static GLProfiler glProfiler;

	// Set the columns and rows properties
	static public int row_height;
	static public int col_width;

	@Override
	public void create () {
		// Set the columns and rows properties
		row_height = Gdx.graphics.getWidth() / 12;
		col_width = Gdx.graphics.getWidth() / 12;

		batch = new SpriteBatch();
		rm = new ResourceManager();

		// Player
		player = new Player("Player", rm);

		// Save
		save = new Save("save.json");
		save.load(rm);

		// debugging fps
		//TODO modify the font
		fps = new Label("", new Label.LabelStyle(rm.font, Color.RED));
		fps.setFontScale(0.5f);
		//TODO replace with a boolean setting
		fps.setVisible(true);


		// Background settings
		menuBackground = new Background[1];

		//TODO set background layers

		// Profiler for logging
		glProfiler = new GLProfiler(Gdx.graphics);
		glProfiler.enable();

		// Set the screen to TitleScreen
		changeScreen(ScreenState.TITLE_SCREEN);
	}

	/**
	 * Controls which screen will be shown
	 * @param screen
	 */
	public void changeScreen(ScreenState screen) {
		switch (screen) {
            case TITLE_SCREEN:
				if(titleScreen == null) titleScreen = new TitleScreen(this, rm);
				this.setScreen(titleScreen);
				break;
            case OPTIONS_SCREEN:
				if(optionsScreen == null) optionsScreen = new OptionsScreen(this, rm);
				this.setScreen(optionsScreen);
				break;
            case PLAY_SCREEN:
				if(playScreen == null) playScreen = new GameScreen(this, rm);
				this.setScreen(playScreen);
				break;
		}
	}

	@Override
	public void render () {
		fps.setText(Gdx.graphics.getFramesPerSecond() + " fps");
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
		super.dispose();

		glProfiler.disable();
	}

	/**
	 * Logs profile for SpriteBatch calls
	 * Uses GLProfiler
	 */
	public void logProfile(String source) {
		System.out.println("Profiling " + source + "..." + "\n" +
				"  Drawcalls: " + glProfiler.getDrawCalls() +
				", Calls: " + glProfiler.getCalls() +
				", TextureBindings: " + glProfiler.getTextureBindings() +
				", ShaderSwitches:  " + glProfiler.getShaderSwitches() +
				" vertexCount: " + glProfiler.getVertexCount().value);
		glProfiler.reset();
	}
}
