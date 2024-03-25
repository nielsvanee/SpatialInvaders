package org.example.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PowerupTextEntity extends TextEntity {
    public PowerupTextEntity(Coordinate2D initialLocation) {
        super(initialLocation, "Powerup: None");

        setFont(Font.font("Roboto", FontWeight.NORMAL, 20));
        setFill(Color.WHITESMOKE);
    }

    public void updatePowerup(String powerup) {
        setText("Powerup: " + powerup);
    }
}
