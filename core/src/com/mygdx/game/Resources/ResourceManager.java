package com.mygdx.game.Resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Manages the resources such as musics, images, maps
 *
 * @author gfresnais
 */
public class ResourceManager {
    public AssetManager assetManager;

    // Skins
    public Skin skin;
    private String skinPath = "skins/";

    // Fonts
    public final BitmapFont font;

    public ResourceManager() {
        assetManager = new AssetManager();

        // Load the assets
        // TODO

        assetManager.finishLoading();

        // Initialize the font
        //TODO add a new font file
        font = new BitmapFont();

        // Skin for the app
        skin = new Skin(Gdx.files.internal(skinPath + "glassy/glassy-ui.json"));
    }

    /**
     * Sets general music volume
     * @param volume
     */
    public void setMusicVolume(float volume) {

    }

    /**
     * Dispose of everything loaded in memory
     */
    public void dispose() {
        assetManager.dispose();
        font.dispose();
    }
}
