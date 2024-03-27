package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import org.example.entities.Spaceship;
import org.example.entities.spawners.BulletSpawner;
import org.example.entities.spawners.MovingObjectSpawner;
import org.example.settings.GameSettings;

public class GameScene extends DynamicScene implements EntitySpawnerContainer {

    private final GameSettings difficulty;
    private Spaceship player;
    private int score;

    public GameScene(GameSettings difficulty) {
        super();
        this.difficulty = difficulty;
        this.score = 0;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.DARKSLATEGRAY);
    }

    @Override
    public void setupEntities() {
        player = new Spaceship(new Coordinate2D(getWidth() / 2, getHeight() - 50), new Size(50, 50), difficulty.getStartHealth());

        addEntity(player);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new MovingObjectSpawner(getWidth(), difficulty.getSpawnInterval(), this));
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
        spatialInvaders.setScore(score);
        score = 0;
        spatialInvaders.setActiveScene(0);
    }

    public void setScoreMultiplier(int i) {
        scoreMultiplier = i;
    }
}
