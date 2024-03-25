package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.example.scenes.GameScene;

public abstract class FallingObject extends DynamicSpriteEntity implements Collided, SceneBorderTouchingWatcher {

    protected GameScene game;

    public FallingObject(String resource, Coordinate2D initialLocation, GameScene game) {
        super(resource, initialLocation, new Size(32, 32));
        this.game = game;
        setMotion(1, 0d);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        if (sceneBorder == SceneBorder.BOTTOM) {
            this.remove();
        }
    }
}
