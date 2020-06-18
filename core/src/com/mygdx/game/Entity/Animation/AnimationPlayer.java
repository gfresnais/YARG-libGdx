package com.mygdx.game.Entity.Animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Entity.Player;
import com.mygdx.game.Resources.ResourceManager;

/**
 * Handles animation for the player
 *
 * @author gfresnais
 *
 * Credits to
 * @author lilian-vallee
 */
public class AnimationPlayer {
    private Player player;

    // Animations utils
    private TextureRegion am;
    private int animIndex;

    // 0 down, 1 up, 2 left, 3 right
    private Animation[] animations;

    // Time for each frame
    private float stateTime;

    /**
     * Constructor
     * @param player
     * @param rm
     */
    public AnimationPlayer(Player player, ResourceManager rm) {
        this.player = player;

        // Four directions
        animations = new Animation[4];

        // Gets all the rows of the sprites
        for (int i = 0; i < rm.player32x32.length; i++) {
            Array<TextureRegion> frames = new Array<TextureRegion>();
            for (int j = 0; j < (rm.player32x32.length - 1); j++) {
                frames.add(rm.player32x32[i][j]);
            }
            animations[i] = new Animation<TextureRegion>(0.1f, frames);
        }

        animIndex = 0;

        am = (TextureRegion) animations[animIndex].getKeyFrame(0);
    }

    /**
     * Updates the animation
     * @param delta
     */
    public void update(float delta) {
        stateTime += delta;
        am = (TextureRegion) animations[animIndex].getKeyFrame(stateTime, true);
    }

    /**
     * Returns the current animation as a TextureRegion
     * @return
     */
    public TextureRegion getAm() { return am; }

    /**
     * Sets the animation index
     * @param animIndex
     */
    public void setAnimIndex(int animIndex) { this.animIndex = animIndex; }
}
