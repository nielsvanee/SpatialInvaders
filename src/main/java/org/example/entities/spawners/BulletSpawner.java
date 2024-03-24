package org.example.entities.spawners;

import com.github.hanyaeger.api.entities.EntitySpawner;
import org.example.entities.Bullet;
import org.example.entities.Spaceship;

public class BulletSpawner extends EntitySpawner {

    private final Spaceship player;

    public BulletSpawner(long intervalInMs, Spaceship player) {
        super(intervalInMs);
        this.player = player;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Bullet(player.getLocation()));
    }
}
