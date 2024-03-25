package org.example.entities.powerups;

import org.example.entities.Spaceship;

public class Speed implements Powerup {

    @Override
    public void activate(Spaceship s) {
        s.setSpeedmultiplier(2);
    }

    @Override
    public void deactivate(Spaceship s) {
        s.setSpeedmultiplier(1);
    }

    @Override
    public String toString() {
        return "Speed";
    }
}
