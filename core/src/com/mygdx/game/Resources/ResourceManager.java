package com.mygdx.game.Resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Manages the resources such as musics, images, maps
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class ResourceManager {
    public AssetManager assetManager;

    // Texture atlas for the sprites
    public TextureAtlas atlas;

    // Skins
    public Skin skin;
    private String skinPath = "skins/";

    // Fonts
    public final BitmapFont font;

    // Player
    public TextureRegion[][] player32x32;

    // Music
    public Music menuTheme;

    /**
     * Constructor for ResourceManager
     */
    public ResourceManager() {
        assetManager = new AssetManager();

        // Load the assets
        // TODO
        assetManager.load("sprites.atlas", TextureAtlas.class);

        assetManager.load("music/Theme 1.mp3", Music.class);

        assetManager.finishLoading();

        // Loads the sprites atlas file
        atlas = assetManager.get("sprites.atlas");

        // Debugging
        System.out.println(">>RM atlas regions");
        System.out.println(atlas.getRegions());
        System.out.println(">> END RM");

        // sprites, searches a specific region
        player32x32 = atlas.findRegion("Male/Male 01-1").split(32, 32);



        // Initialize the font
        //TODO add a new font file
        font = new BitmapFont();

        // Load the music
        menuTheme = assetManager.get("music/Theme 1.mp3", Music.class);

        // Skin for the app
        skin = new Skin(Gdx.files.internal(skinPath + "glassy/glassy-ui.json"));
    }

    /**
     * TODO add functionalities
     * Sets general music volume
     * @param volume
     */
    public void setMusicVolume(float volume) {}

    /**
     * Stops all musics played
     */
    public void stopAllMusics() {
        menuTheme.stop();
    }

    /**
     * Plays a music corresponding to the given id
     * Looping sets the loop
     * @param id
     * @param looping
     */
    public void playMusic(int id, boolean looping) {
        stopAllMusics();
        switch (id) {
            case 1:
                menuTheme.setLooping(looping);
                menuTheme.play();
                break;
            default:
                break;
        }
    }

    /**
     * Dispose of everything loaded in memory
     */
    public void dispose() {
        assetManager.dispose();
        font.dispose();
        skin.dispose();
        atlas.dispose();

        menuTheme.dispose();
    }
}
