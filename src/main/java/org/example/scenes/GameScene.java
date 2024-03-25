package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import org.example.entities.Spaceship;
import org.example.entities.powerups.Powerup;
import org.example.entities.powerups.Speed;
import org.example.entities.spawners.BulletSpawner;
import org.example.entities.spawners.FallingObjectSpawner;
import org.example.entities.text.HealthTextEntity;
import org.example.entities.text.ScoreTextEntity;
import org.example.settings.GameSettings;

import java.util.Random;

public class GameScene extends DynamicScene implements EntitySpawnerContainer {

    private final GameSettings difficulty;

    private Spaceship player;
    private final TextEntity healthText;
    private final TextEntity scoreText;

    private int score;

    private Powerup powerup;

    public GameScene(GameSettings difficulty) {
        super();
        this.difficulty = difficulty;
        this.score = 0;
        this.healthText = new HealthTextEntity(new Coordinate2D(10, 10), 10);
        this.scoreText = new ScoreTextEntity(new Coordinate2D(10, 30), score);
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.DARKSLATEGRAY);
    }

    @Override
    public void setupEntities() {
        player = new Spaceship(new Coordinate2D(getWidth() / 2, getHeight() - 50), new Size(50, 50), difficulty.getStartHealth(), this);

        addEntity(player);
        addEntity(healthText);
        addEntity(scoreText);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new FallingObjectSpawner(getWidth(), difficulty.getSpawnInterval(), this));
        addEntitySpawner(new BulletSpawner(500, player));
    }

    public void addScore(int i) {
        score += i;
        scoreText.setText("Score: " + score);
    }

    public void addRandomPowerup() {
        if (powerup != null) {
            powerup.deactivate(player);
        }

        Random r = new Random();
        int randomNumber = r.nextInt(1, 3);

        switch(randomNumber) {
            case 1:
                powerup = new Speed();
                break;
            case 2:
                powerup = new Speed();
                break;
        }
        powerup.activate(player);

    }

    public void setHealthText(int health) {
        healthText.setText("Health: " + health);
    }
}
