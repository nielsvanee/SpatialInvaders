package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Bullet extends DynamicSpriteEntity implements Collider {
    public Bullet(Coordinate2D initialLocation) {
        super("entities/bullet.png", initialLocation);
        setMotion(5, 180d);
    }
}
