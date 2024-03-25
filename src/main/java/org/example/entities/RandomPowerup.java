package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import org.example.scenes.GameScene;

import java.util.List;

public class RandomPowerup extends FallingObject {

    public RandomPowerup(Coordinate2D initialLocation, GameScene game) {
        super("entities/powerup.png", initialLocation, game);
    }

    @Override
    public void onCollision(List<Collider> list) {
        Collider c = list.getFirst();
        if (c instanceof Spaceship) {
            game.addRandomPowerup();
            this.remove();
        }
    }
}
