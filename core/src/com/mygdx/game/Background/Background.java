package com.mygdx.game.Background;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.YARG;

/**
 * Background management for game screens
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class Background {

    public TextureRegion image;
    // Has its own camera
    private OrthographicCamera cam;
    // To scale the camera
    public Vector2 scale;


    // parallax
    private float ax;
    private float ay;
    private int numDrawX;
    private int numDrawY;

    // background movement
    private float dx;
    private float dy;

    /**
     * Constructor
     * @param cam
     * @param scale
     */
    public Background(OrthographicCamera cam, Vector2 scale) {
        this.cam = cam;
        this.scale = scale;
    }

    /**
     * Constructor
     * @param image
     * @param cam
     * @param scale
     */
    public Background(TextureRegion image, OrthographicCamera cam, Vector2 scale) {
        this(cam, scale);
        setImage(image);
    }

    /**
     * Sets the TextureRegion
     * @param image
     */
    public void setImage(TextureRegion image) {
        this.image = image;
        numDrawX = (YARG.V_WIDTH * 2) / image.getRegionWidth() + 1;
        numDrawY = (YARG.V_HEIGHT * 2) / image.getRegionHeight() + 1;
    }


    /**
     * Sets the vector dimensions
     * @param dx
     * @param dy
     */
    public void setVector(float dx, float dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Updates the background's position
     * @param delta
     */
    public void update(float delta) {
        ax += (dx * scale.x) * delta;
        ay += (dy * scale.y) * delta;
    }

    /**
     * Renders the background
     * @param batch
     */
    public void render(SpriteBatch batch) {
        // If the background is not moving
        if( dx == 0 && dy == 0 ) {
             batch.draw(image, 0, 0);
        } else {
            float x = ((ax + cam.viewportWidth / 2 - cam.position.x) * scale.x) % image.getRegionWidth();
            float y = ((ay + cam.viewportHeight / 2 - cam.position.y) * scale.y) % image.getRegionHeight();

            // check the offsets according to the coordinates
            int colOffset = x > 0 ? -1 : 0;
            int rowOffset = y > 0 ? -1 : 0;

            // Draws all background elements
            for(int row = 0; row < numDrawY; row++) {
                for(int col = 0; col < numDrawX; col++) {
                    float offsetX = x + (col + colOffset) * image.getRegionWidth();
                    float offsetY = y + (row + rowOffset) * image.getRegionHeight();
                    batch.draw(image, offsetX, offsetY);
                }
            }
        }
    }
}
