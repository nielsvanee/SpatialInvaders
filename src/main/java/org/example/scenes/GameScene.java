package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import org.example.entities.Spaceship;
import org.example.entities.spawners.MovingObjectSpawner;
import org.example.settings.GameSettings;

public class GameScene extends DynamicScene implements EntitySpawnerContainer {

    private final GameSettings difficulty;

    public GameScene(GameSettings difficulty) {
        super();
        this.difficulty = difficulty;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.DARKSLATEGRAY);
    }

    @Override
    public void setupEntities() {
        Spaceship player = new Spaceship(new Coordinate2D(getWidth() / 2, getHeight() - 50), new Size(50, 50), difficulty.getStartHealth());

        addEntity(player);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new MovingObjectSpawner(getWidth(), difficulty.getSpawnInterval()));
    }
}
