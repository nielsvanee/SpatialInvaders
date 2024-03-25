package org.example.entities.powerups;

import org.example.entities.Spaceship;

public interface Powerup {
    void activate(Spaceship s);
    void deactivate(Spaceship s);
}
