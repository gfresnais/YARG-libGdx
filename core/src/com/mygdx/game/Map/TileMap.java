package com.mygdx.game.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * TileMap creation
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class TileMap {
    private TiledMap tiledMap;
    private TiledMapRenderer tiledMapRenderer;

    private final float unitScale = 1 / 3f;

    private MapLayers layers;

    // Map utils for file loading
    private final String mapPath = "maps/";
    private final String mapExt = ".tmx";

    // Coordinates and spawn informations
    private Vector2 origin;
    private  Vector2 playerSpawn;

    // map informations
    private int mapWidth;
    private int mapHeight;
    private int tileWidth;
    private int tileHeight;

    /**
     * Constructor with the map name
     * @param mapName
     */
    public TileMap(String mapName) {
        // Direct loading the tilemap file
        tiledMap = new TmxMapLoader().load(mapPath + mapName + mapExt);

        // Maps layers
        layers = tiledMap.getLayers();

        // Map properties
        mapWidth = (Integer) tiledMap.getProperties().get("width");
        mapHeight = (Integer) tiledMap.getProperties().get("height");
        tileWidth = (Integer) tiledMap.getProperties().get("tilewidth");
        tileHeight = (Integer) tiledMap.getProperties().get("tileheight");

        // Map renderer
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, unitScale);

        //System.out.println(getMapProperties());
    }

    /**
     * Updates the entities
     * @param delta
     */
    public void update(float delta) {
        //TODO check the correct way to update the tileMap
    }

    /**
     * Rendering with a batch and a camera
     * Batch to draw entities
     * Camera to follow the player and check the borders
     * @param batch
     * @param cam
     */
    public void render(SpriteBatch batch, OrthographicCamera cam) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cam.update();
        tiledMapRenderer.setView(cam);
        tiledMapRenderer.render();
    }

    /**
     * Deleting from memory
     */
    public void dispose() {
        tiledMap.dispose();
    }


    /**
     * For debugging purposes
     * @return properties of the map
     */
    public String getMapProperties() {
        String strLayers = "\n";
        for (MapLayer layer:
             layers) {
            strLayers += layer.getName();
            strLayers += "\n";
        }
        return "width = " + mapWidth +
                ", height = " + mapHeight +
                ", tilewidth = " + tileWidth +
                ", tileheight =" + tileHeight +
                ", layers = " + strLayers;
    }
}
