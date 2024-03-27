package org.example.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import org.example.scenes.GameScene;

import java.util.List;

public class Debris extends FallingObject {

    private int health;

    public Debris(Coordinate2D initialLocation, GameScene game) {
        super("entities/debris.png", initialLocation, game);
        this.health = 2;
    }

    @Override
    public void onCollision(List<Collider> list) {
        Collider c = list.getFirst();
        if (c instanceof Spaceship s) {
            s.takeDamage(2);
            this.remove();
        }

        if (c instanceof Bullet b) {
            health--;
            b.remove();
            if (health == 0) {
                game.addScore(3);
                this.remove();
            }
        }
    }
}
