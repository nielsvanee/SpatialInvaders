package org.example.entities.powerups;

import org.example.entities.Spaceship;

public class DoubleScore implements Powerup{
    @Override
    public void activate(Spaceship s) {
        s.setScoreMultiplier(2);
    }

    @Override
    public void deactivate(Spaceship s) {
        s.setScoreMultiplier(1);
    }

    @Override
    public String toString() {
        return "2x Score";
    }
}
