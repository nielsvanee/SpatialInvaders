package org.example.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.example.scenes.GameScene;

import java.util.Set;

public class Spaceship extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collider {

    private int health;
    private int speedmultiplier;
    private GameScene game;

    public Spaceship(Coordinate2D initialLocation, Size size, int startHealth, GameScene game) {
        super("entities/spaceship.png", initialLocation, size);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setGravityConstant(0);
        setFrictionConstant(0.03);

        this.health = startHealth;
        this.speedmultiplier = 1;
        this.game = game;
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if (set.contains(KeyCode.LEFT)) {
            setMotion(speedmultiplier, 270d);
        } else if (set.contains(KeyCode.RIGHT)) {
            setMotion(speedmultiplier, 90d);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        setSpeed(0);

        switch (sceneBorder) {
            case LEFT:
                setAnchorLocationX(this.getWidth() / 2 + 1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - this.getWidth() / 2 - 1);
                break;
        }
    }

    public void takeDamage() {
        health--;
        game.setHealthText(health);
    }

    public void setSpeedmultiplier(int speedmultiplier) {
        this.speedmultiplier = speedmultiplier;
    }

    public Coordinate2D getLocation() {
        return this.getLocationInScene();
    }

    public int getHealth() {
        return health;
    }
}
