package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class MovingObject extends DynamicSpriteEntity implements Collided {
    public MovingObject(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }
}
