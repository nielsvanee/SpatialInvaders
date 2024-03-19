package org.example;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.example.scenes.GameScene;
import org.example.scenes.TitleScene;
import org.example.settings.Easy;
import org.example.settings.GameSettings;

/**
 * Hello world!
 *
 */
public class SpatialInvaders extends YaegerGame
{

    private final GameSettings difficulty = new Easy();

    public static void main( String[] args ) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Spatial Invaders");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameScene(difficulty));
    }
}
