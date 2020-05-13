package com.mygdx.game.Animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Manages animations for entities
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ming Li
 */
public class AnimationManager {

    public float width;
    public float height;

    // Animation
    private CustomAnimation currentAnimation;

    /**
     * Constructor for single animations
     *
     * @param sprites
     * @param numFrames
     * @param index
     * @param delay
     */
    public AnimationManager(TextureRegion[][] sprites, int numFrames, int index, float delay) {
        TextureRegion[] frames = new TextureRegion[numFrames];

        width = sprites[index][0].getRegionWidth();
        height = sprites[index][0].getRegionHeight();

        System.arraycopy(sprites[index], 0, frames, 0, numFrames);

        currentAnimation = new CustomAnimation(delay, frames);
    }

    /**
     * Updates the animation
     * @param delta
     */
    public void update(float delta) {
        currentAnimation.update(delta);
        currentAnimation.play();
    }

    /**
     * Stops the current animation
     */
    public void stopAnimation() {
        currentAnimation.stop();
    }
}
