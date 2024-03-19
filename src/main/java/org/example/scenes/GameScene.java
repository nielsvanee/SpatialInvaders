package org.example.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import javafx.scene.paint.Color;
import org.example.entities.Spaceship;

public class GameScene extends DynamicScene {
    @Override
    public void setupScene() {
        setBackgroundColor(Color.DARKSLATEGRAY);
    }

    @Override
    public void setupEntities() {
        Spaceship player = new Spaceship(new Coordinate2D(getWidth() / 2, getHeight() - 50), new Size(50, 50));

        addEntity(player);
    }
}
