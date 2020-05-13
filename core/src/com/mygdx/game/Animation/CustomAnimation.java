package com.mygdx.game.Animation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * A custom animation class extending the Animation from libGdx
 *
 * @author gfresnais
 *
 * Credits to
 * @author Ivan Vinski
 * @since 1.0
 */
public class CustomAnimation extends Animation {

    private float stateTime;
    private boolean playing;

    public CustomAnimation(float frameDuration, Array keyFrames) {
        super(frameDuration, keyFrames);
    }

    public CustomAnimation(float frameDuration, Array keyFrames, PlayMode playMode) {
        super(frameDuration, keyFrames, playMode);
    }

    public CustomAnimation(float frameDuration, Object[] keyFrames) {
        super(frameDuration, keyFrames);
    }

    public void play() {
        if(!playing) playing = true;
    }

    public void pause() {
        if(playing) playing = false;
    }

    public void stop() {
        reset();
        pause();
    }

    public void update(float delta) {
        if(playing) stateTime += delta;
    }

    public void reset() {
        if( stateTime != 0f ) stateTime = 0f;
    }

    public TextureRegion getKeyFrame(boolean looping) {
        return (TextureRegion) getKeyFrame(stateTime, looping);
    }

    public TextureRegion getKeyFrame() {
        return (TextureRegion) getKeyFrame(stateTime);
    }

    public int getKeyFrameIndex() {
        return getKeyFrameIndex(stateTime);
    }

    public boolean isAnimationFinished() {
        return isAnimationFinished(stateTime);
    }

    public boolean isPlaying() {
        return playing;
    }
}
