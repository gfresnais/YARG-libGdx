package com.mygdx.game.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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
    private Texture img;
    private TiledMap tiledMap;
    private OrthographicCamera camera;
    private TiledMapRenderer tiledMapRenderer;

    private final float unitScale = 1 / 32f;

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

        // Camera settings
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 20, 10);
        camera.update();

        // Map renderer
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, unitScale);
    }

    /**
     * Rendering
     */
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
    }

    /**
     * Deleting from memory
     */
    public void dispose() {
        img.dispose();
        tiledMap.dispose();
    }

    public OrthographicCamera getCamera() {
        return camera;
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
