package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public class Asteroid extends MovingObject implements Newtonian, SceneBorderTouchingWatcher {

    public Asteroid(Coordinate2D initialLocation) {
        super("entities/asteroid.png", initialLocation, new Size(32, 32));
        setGravityConstant(0.03);
        setFrictionConstant(0.03);
    }

    @Override
    public void onCollision(List<Collider> list) {
        Collider c = list.getFirst();
        if (c instanceof Spaceship s) {
            s.takeDamage();
            this.remove();
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        if (sceneBorder == SceneBorder.BOTTOM) {
            this.remove();
        }
    }
}
