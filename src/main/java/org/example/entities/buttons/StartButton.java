package org.example.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.SpatialInvaders;

public class StartButton extends TextEntity implements MouseButtonPressedListener {

    private final SpatialInvaders game;

    public StartButton(Coordinate2D initialLocation, SpatialInvaders game) {
        super(initialLocation, "Start game");
        setFill(Color.CRIMSON);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        this.game = game;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        game.setActiveScene(1);
    }
}
