package org.example.entities.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.example.entities.Asteroid;
import org.example.scenes.GameScene;

import java.util.Random;

public class MovingObjectSpawner extends EntitySpawner {

    private final GameScene game;
    private final double sceneWidth;

    public MovingObjectSpawner(double sceneWidth, long intervalInMs, GameScene game) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.game = game;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Asteroid(getRandomLocation(), game));
    }

    private Coordinate2D getRandomLocation() {
        Random r = new Random();
        double x = r.nextDouble() * sceneWidth;
        double clampedx = Math.clamp(x, 16, sceneWidth - 16);
        return new Coordinate2D(clampedx, -16);
    }
}
