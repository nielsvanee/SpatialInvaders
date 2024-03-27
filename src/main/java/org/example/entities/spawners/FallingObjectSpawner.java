package org.example.entities.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.example.entities.Asteroid;
import org.example.entities.Debris;
import org.example.entities.FallingObject;
import org.example.entities.RandomPowerup;
import org.example.scenes.GameScene;

import java.util.Random;

public class FallingObjectSpawner extends EntitySpawner {

    private final GameScene game;
    private final double sceneWidth;

    public FallingObjectSpawner(double sceneWidth, long intervalInMs, GameScene game) {
        super(intervalInMs);
        this.sceneWidth = sceneWidth;
        this.game = game;
    }

    @Override
    protected void spawnEntities() {
        Random r = new Random();
        int randomNumber = r.nextInt(1, 10);
        
        FallingObject fallingObject;
        
        if (randomNumber == 1)
            fallingObject = new RandomPowerup(getRandomLocation(), game);
        else if (randomNumber == 2)
            fallingObject = new Debris(getRandomLocation(), game);
        else
            fallingObject = new Asteroid(getRandomLocation(), game);

        spawn(fallingObject);
    }

    private Coordinate2D getRandomLocation() {
        Random r = new Random();
        double x = r.nextDouble() * sceneWidth;
        double clampedx = Math.clamp(x, 16, sceneWidth - 16);
        return new Coordinate2D(clampedx, -16);
    }
}
