package org.example.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HealthTextEntity extends TextEntity {
    public HealthTextEntity(Coordinate2D initialLocation, int initialHealth) {
        super(initialLocation, "Health: " + initialHealth);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 20));
        setFill(Color.WHITESMOKE);
    }

    public void updateHealth(int health) {
        setText("Health: " + health);
    }
}
