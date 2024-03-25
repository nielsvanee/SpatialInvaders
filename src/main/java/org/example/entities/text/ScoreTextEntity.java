package org.example.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreTextEntity extends TextEntity {
    public ScoreTextEntity(Coordinate2D initialLocation, int initialScore) {
        super(initialLocation, "Score: " + initialScore);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 20));
        setFill(Color.WHITESMOKE);
    }

    public void updateScore(int score) {
        setText("Score: " + score);
    }
}
