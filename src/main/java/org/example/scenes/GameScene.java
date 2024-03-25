package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import org.example.SpatialInvaders;
import org.example.entities.Spaceship;
import org.example.entities.powerups.DoubleScore;
import org.example.entities.powerups.Powerup;
import org.example.entities.powerups.Speed;
import org.example.entities.spawners.BulletSpawner;
import org.example.entities.spawners.FallingObjectSpawner;
import org.example.entities.text.HealthTextEntity;
import org.example.entities.text.PowerupTextEntity;
import org.example.entities.text.ScoreTextEntity;
import org.example.settings.GameSettings;

import java.util.Random;

public class GameScene extends DynamicScene implements EntitySpawnerContainer {

    private final SpatialInvaders spatialInvaders;

    private final GameSettings difficulty;

    private Spaceship player;
    private final HealthTextEntity healthText;
    private final ScoreTextEntity scoreText;
    private final PowerupTextEntity powerupText;

    private int score;
    private int scoreMultiplier;

    private Powerup powerup;

    public GameScene(SpatialInvaders spatialInvaders, GameSettings difficulty) {
        super();
        this.spatialInvaders = spatialInvaders;
        this.difficulty = difficulty;
        this.score = 0;
        this.scoreMultiplier = 1;
        this.healthText = new HealthTextEntity(new Coordinate2D(10, 10), difficulty.getStartHealth());
        this.scoreText = new ScoreTextEntity(new Coordinate2D(10, 30), score);
        this.powerupText = new PowerupTextEntity(new Coordinate2D(10, 50));
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
        addEntity(powerupText);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new FallingObjectSpawner(getWidth(), difficulty.getSpawnInterval(), this));
        addEntitySpawner(new BulletSpawner(500, player));
    }

    public void addScore(int i) {
        score += i * scoreMultiplier;
        scoreText.updateScore(score);
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
                powerup = new DoubleScore();
                break;
        }
        powerup.activate(player);
        powerupText.updatePowerup(powerup.toString());

    }

    public void setHealthText(int health) {
        healthText.updateHealth(health);
    }

    public void gameOver() {
        spatialInvaders.setActiveScene(0);
    }

    public void setScoreMultiplier(int i) {
        scoreMultiplier = i;
    }
}
